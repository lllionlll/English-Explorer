package io.graduation.haui.ui.book_list

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import com.bumptech.glide.Glide
import io.graduation.haui.bases.BaseAdapter
import io.graduation.haui.data.model.BookDetail
import io.graduation.haui.databinding.ItemBookBinding
import kotlin.math.log


/**
- Create by :Vy Hùng
- Create at :16,December,2023
 **/

private const val TAG = "BookListNewAdapter"

class BookListNewAdapter(private val onOpenBook: (Int) -> Unit) :
    BaseAdapter<BookDetail, ItemBookBinding>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<BookDetail> {
        val binding = ItemBookBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    inner class ViewHolder(binding: ItemBookBinding) :
        BaseViewHolder<BookDetail>(binding) {

        override fun setData(item: BookDetail) {
            super.setData(item)
            binding.apply {
                Glide.with(binding.image).load(item.bookImg).into(binding.image)
                binding.unitName.text = item.bookName
            }
        }
    }

}