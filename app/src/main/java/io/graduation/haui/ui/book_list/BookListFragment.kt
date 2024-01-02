package io.graduation.haui.ui.book_list

import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import io.graduation.haui.bases.BaseFragment
import io.graduation.haui.databinding.FragmentBookListBinding
import io.graduation.haui.utils.LoadingDialog

@AndroidEntryPoint
class BookListFragment : BaseFragment<FragmentBookListBinding>(
    FragmentBookListBinding::inflate
) {

    private val bookListVM by viewModels<BookListVM>()
    private var bookListAdapter = BookListAdapter(
        onClickBook = { bookId ->
//            BookListRoute.goToUnit(
//                fragment = this,
//                bookId = bookId
//            )
        }
    )

    override fun initData() {
        super.initData()
        binding.rcBookList.adapter = bookListAdapter
        binding.rcBookList.itemAnimator = null
        bookListVM.getBookList()
    }

    override fun observerData() {
        super.observerData()
        bookListVM.isLoading.observe(viewLifecycleOwner) { isLoading ->
            if (isLoading) {
                LoadingDialog.showLoading(requireContext())
            } else {
                LoadingDialog.hide()
            }
        }

        bookListVM.bookDetailList.observe(viewLifecycleOwner) { bookList ->
            if (bookList.isNotEmpty()) {
                bookListAdapter.setItemList(bookList)
            }
        }
    }

}