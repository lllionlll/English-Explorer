package io.graduation.haui.ui.menu

import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

object MenuRoute {

    fun goToUnit(fragment: Fragment) {
        val action = MenuFragmentDirections.actionMenuListFragmentToUnitListFragment()
        fragment.findNavController().navigate(action)
    }

}