package io.graduation.haui.ui.unit_list

import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

object UnitListRoute {

    fun goToVocabulary(fragment: Fragment, bookId: Int = -1, unitId: Int = -1) {
        val action = UnitListFragmentDirections.actionUnitListFragmentToVocabularyListFragment(
            bookId = bookId,
            unitId = unitId
        )
        fragment.findNavController().navigate(action)
    }

}