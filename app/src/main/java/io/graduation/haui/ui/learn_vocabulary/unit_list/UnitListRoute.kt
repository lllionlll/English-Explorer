package io.graduation.haui.ui.learn_vocabulary.unit_list

import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

object UnitListRoute {

    fun goToVocabulary(fragment: Fragment, unitId: Int = -1) {
        val action = UnitListFragmentDirections.actionUnitListFragmentToVocabularyListFragment(
            unitId = unitId
        )
        fragment.findNavController().navigate(action)
    }

    fun goToSearch(fragment: Fragment) {
        val action = UnitListFragmentDirections.actionUnitListFragmentToSearchFragment()
        fragment.findNavController().navigate(action)
    }

    fun back(fragment: Fragment) {
        fragment.findNavController().popBackStack()
    }

}