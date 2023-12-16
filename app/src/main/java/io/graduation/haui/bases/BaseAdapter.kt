package io.graduation.haui.bases

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

abstract class BaseAdapter<T, B : ViewBinding>() :
    RecyclerView.Adapter<BaseAdapter<T, B>.BaseViewHolder<T>>() {

    val itemList: MutableList<T> = mutableListOf()

    open inner class BaseViewHolder<A>(val binding: B) : RecyclerView.ViewHolder(binding.root) {

        private var item: T? = null

        init {
           // setItemClick(binding)
        }

        open fun setData(item: T) {
            this.item = item
        }
    }

//    abstract fun  setItemClick(binding: B)

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: BaseViewHolder<T>, position: Int) {
        itemList.getOrNull(position)?.let { data ->
            holder.setData(data)
        }
    }


    fun setListItem(itemList: MutableList<T>) {
        this.itemList.clear()
        this.itemList.addAll(itemList)
        notifyItemRangeInserted(0, itemList.size)
    }
}