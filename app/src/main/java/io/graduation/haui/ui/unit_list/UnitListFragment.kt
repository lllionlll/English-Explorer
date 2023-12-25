package io.graduation.haui.ui.unit_list

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import dagger.hilt.android.AndroidEntryPoint
import io.graduation.haui.bases.BaseFragment
import io.graduation.haui.databinding.FragmentUnitListBinding
import io.graduation.haui.utils.LoadingDialog

@AndroidEntryPoint
class UnitListFragment : BaseFragment<FragmentUnitListBinding>(
    FragmentUnitListBinding::inflate
) {

    private val unitListVM by viewModels<UnitListVM>()
    private val safeArgs by navArgs<UnitListFragmentArgs>()

    private val unitAdapter = UnitAdapter(
        onClickUnit = { bookId ->
            UnitListRoute.goToVocabulary(
                fragment = this,
                bookId = bookId
            )
        }
    )

    override fun initData() {
        super.initData()
        binding.rcUnitList.adapter = unitAdapter
        binding.rcUnitList.itemAnimator = null
        unitListVM.getUnitList(book = safeArgs.bookId)
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