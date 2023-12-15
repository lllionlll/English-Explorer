package io.graduation.haui.ui.book_list

import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import io.graduation.haui.R
import io.graduation.haui.bases.BaseFragment
import io.graduation.haui.databinding.FragmentBookListBinding
import io.graduation.haui.utils.LoadingDialog
import io.graduation.haui.utils.navigate

@AndroidEntryPoint
class BookListFragment : BaseFragment<FragmentBookListBinding>(
    FragmentBookListBinding::inflate
) {

    private val bookListVM by viewModels<BookListVM>()
    private var bookListAdapter = BookListAdapter(
        onOpenBook = { book ->
            navigate(
                R.layout.fragment_book_list,
                R.id.unitListFragment
            )
        }
    )

    override fun setUpView() {
        super.setUpView()
        binding.rcBookList.adapter = bookListAdapter
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
                bookListAdapter.setBookList(bookList)
            }
        }
    }

}