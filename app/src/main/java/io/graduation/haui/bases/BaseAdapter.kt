package io.graduation.haui.bases

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

abstract class BaseAdapter<T, B: ViewDataBinding>: RecyclerView.Adapter<BaseAdapter<T, B>.BaseViewHolder>() {

    private val itemList: MutableList<T> = mutableListOf()

    inner class BaseViewHolder(val binding: B): RecyclerView.ViewHolder(binding.root) {

        init {
            setItemClick(binding)
        }

        fun setData(itemData: T) {
            setItemData(itemData)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<B>(
            inflater,
            getLayoutIdForType(viewType),
            parent,
            false
        )

        return BaseViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        itemList.getOrNull(position)?.let { data ->
            holder.setData(data)
        }
    }

    abstract fun getLayoutIdForType(viewType: Int): Int

    abstract fun setItemData(itemData: T)

    abstract fun setItemClick(binding: B)

}