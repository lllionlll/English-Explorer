package io.graduation.haui.ui.learn_vocabulary.unit_list

import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import io.graduation.haui.bases.BaseFragment
import io.graduation.haui.databinding.FragmentUnitListBinding
import io.graduation.haui.utils.LoadingDialog

@AndroidEntryPoint
class UnitListFragment : BaseFragment<FragmentUnitListBinding>(
    FragmentUnitListBinding::inflate
) {

    private val unitListVM by viewModels<UnitListVM>()

    private val unitAdapter = UnitAdapter(
        onClickUnit = { unitId ->
            UnitListRoute.goToVocabulary(
                fragment = this,
                unitId = unitId
            )
        }
    )

    override fun initData() {
        super.initData()
        binding.rcUnitList.adapter = unitAdapter
        binding.rcUnitList.itemAnimator = null
        unitListVM.getUnitList()
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