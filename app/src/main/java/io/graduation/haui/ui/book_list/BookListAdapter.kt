package io.graduation.haui.ui.book_list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import io.graduation.haui.data.model.BookDetail
import io.graduation.haui.databinding.ItemBookBinding
import kotlin.Exception

class BookListAdapter(
    private val onOpenBook: (Int) -> Unit
): RecyclerView.Adapter<BookListAdapter.BookListViewHolder>() {

    private var bookDetailList: MutableList<BookDetail> = mutableListOf()

    inner class BookListViewHolder(private val binding: ItemBookBinding): RecyclerView.ViewHolder(binding.root) {

        init {
            binding.root.setOnClickListener {
                onOpenBook.invoke(layoutPosition)
            }
        }

        fun setData(bookDetail: BookDetail) {
            Glide.with(binding.image).load(bookDetail.bookImg).into(binding.image)
            binding.unitName.text = bookDetail.bookName
        }
    }

    fun setBookList(bookDetailList: MutableList<BookDetail>) {
        try {
            this.bookDetailList.addAll(0, bookDetailList)
            notifyItemRangeInserted(0, this.bookDetailList.size)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BookListAdapter.BookListViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemBookBinding.inflate(inflater, parent, false)
        return BookListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BookListAdapter.BookListViewHolder, position: Int) {
        bookDetailList.getOrNull(position)?.let {
            holder.setData(it)
        }
    }

    override fun getItemCount(): Int {
        return bookDetailList.size
    }
}