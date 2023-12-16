package io.graduation.haui.ui.unit_list

import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import io.graduation.haui.R
import io.graduation.haui.bases.BaseFragment
import io.graduation.haui.databinding.FragmentUnitListBinding
import io.graduation.haui.utils.LoadingDialog
import io.graduation.haui.utils.navigate

@AndroidEntryPoint
class UnitListFragment : BaseFragment<FragmentUnitListBinding>(
    FragmentUnitListBinding::inflate
) {

    private val unitListVM by viewModels<UnitListVM>()
    private val unitAdapter = UnitAdapter(
        openUnit = {
            navigate(
                R.id.unitListFragment,
                R.id.vocabularyListFragment
            )
        }
    )

    override fun initData() {
        super.initData()
        this.arguments?.getInt("BOOK")?.let { book ->
            unitListVM.getUnitList(book = book)
        }
    }

    override fun setUpView() {
        super.setUpView()
        binding.rcUnitList.adapter = unitAdapter
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
                unitAdapter.addUnitList(unitList = unitList)
            }
        }
    }

}