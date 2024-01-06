package io.graduation.haui.ui.learn_vocabulary.unit_list

import android.os.Handler
import android.os.Looper
import androidx.fragment.app.viewModels
import androidx.viewpager2.widget.ViewPager2
import dagger.hilt.android.AndroidEntryPoint
import io.graduation.haui.R
import io.graduation.haui.bases.BaseFragment
import io.graduation.haui.databinding.FragmentUnitListBinding
import io.graduation.haui.ui.image_slider.ImageSliderAdapter
import io.graduation.haui.utils.LoadingDialog

@AndroidEntryPoint
class UnitListFragment : BaseFragment<FragmentUnitListBinding>(
    FragmentUnitListBinding::inflate
) {

    companion object {
        const val TIME_AUTO_SLIDER = 5000L
    }

    private val unitListVM by viewModels<UnitListVM>()
    private val unitAdapter = UnitAdapter(
        onClickUnit = { unitId ->
            UnitListRoute.goToVocabulary(
                fragment = this,
                unitId = unitId
            )
        }
    )

    private val imageSliderAdapter = ImageSliderAdapter()
    private val handler = Handler(Looper.getMainLooper())

    private val autoSliderRunnable = object : Runnable {
        override fun run() {
            val currentItem = binding.vpUnitList.currentItem
            when (currentItem) {
                imageSliderAdapter.itemList.size - 1 -> binding.vpUnitList.setCurrentItem(
                    1,
                    false
                )

                0 -> binding.vpUnitList.setCurrentItem(
                    imageSliderAdapter.itemList.size - 2,
                    false
                )
            }
            binding.vpUnitList.currentItem = currentItem + 1
            handler.postDelayed(this, TIME_AUTO_SLIDER)
        }
    }

    override fun onDestroyView() {
        stopAutoSlider()
        super.onDestroyView()
    }

    override fun initData() {
        super.initData()
        unitListVM.getUnitList()
    }

    override fun initView() {
        super.initView()
        setUpUnitListAdapter()
        setUpImageSliderAdapter()
    }

    private fun setUpUnitListAdapter() {
        binding.rcUnitList.adapter = unitAdapter
        binding.rcUnitList.itemAnimator = null
    }

    private fun setUpImageSliderAdapter() {
        imageSliderAdapter.setItemList(
            mutableListOf(
                R.mipmap.ic_launcher,
                R.drawable.home,
                R.drawable.ic_launcher_background,
                R.mipmap.ic_launcher,
                R.drawable.home
            )
        )
        binding.vpUnitList.adapter = imageSliderAdapter
        binding.vpUnitList.setCurrentItem(1, false)
        binding.vpUnitList.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageScrollStateChanged(state: Int) {
                super.onPageScrollStateChanged(state)

                if (state == ViewPager2.SCROLL_STATE_IDLE) {
                    when (binding.vpUnitList.currentItem) {
                        imageSliderAdapter.itemList.size - 1 -> binding.vpUnitList.setCurrentItem(
                            1,
                            false
                        )

                        0 -> binding.vpUnitList.setCurrentItem(
                            imageSliderAdapter.itemList.size - 2,
                            false
                        )
                    }
                }
            }
        })
        startAutoSlider()
    }

    private fun startAutoSlider() {
        handler.postDelayed(autoSliderRunnable, TIME_AUTO_SLIDER)
    }

    private fun stopAutoSlider() {
        handler.removeCallbacks(autoSliderRunnable)
    }

    override fun observerData() {
        super.observerData()

        unitListVM.isLoading.observe(viewLifecycleOwner) { isLoading ->
            if (isLoading) {
                LoadingDialog.showLoading(requireContext())
            } else {
                LoadingDialog.hide()
            }
        }

        unitListVM.unitList.observe(viewLifecycleOwner) { unitList ->
            if (unitList.isNotEmpty()) {
                unitAdapter.setItemList(itemList = unitList)
            }
        }
    }

}