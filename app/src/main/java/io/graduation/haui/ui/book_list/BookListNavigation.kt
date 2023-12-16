package io.graduation.haui.ui.book_list

import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

object BookListNavigation {

    fun goToUnit(fragment: Fragment, bookId: Int = -1) {
        val action = BookListFragmentDirections.actionBookListFragmentToUnitListFragment(
            bookId = bookId
        )
        fragment.findNavController().navigate(action)
    }

}