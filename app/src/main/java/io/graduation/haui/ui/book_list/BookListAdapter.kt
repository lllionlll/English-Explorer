package io.graduation.haui.ui.book_list

import android.view.LayoutInflater
import android.view.ViewGroup
import com.bumptech.glide.Glide
import io.graduation.haui.bases.BaseAdapter
import io.graduation.haui.data.model.BookDetail
import io.graduation.haui.databinding.ItemBookBinding

class BookListAdapter(
    private val onClickBook: (Int) -> Unit
) : BaseAdapter<BookDetail, ItemBookBinding>() {

    inner class BookListViewHolder(binding: ItemBookBinding) : BaseViewHolder(binding) {

        init {
            binding.root.setOnClickListener {
                itemList.getOrNull(layoutPosition)?.let { bookDetail ->
                    bookDetail.book?.let { bookId ->
                        onClickBook.invoke(bookId)
                    }
                }
            }
        }

        override fun setData(item: BookDetail) {
            Glide.with(binding.image).load(item.bookImg).into(binding.image)
            binding.unitName.text = item.bookName
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemBookBinding.inflate(inflater, parent, false)
        return BookListViewHolder(binding)
    }

}