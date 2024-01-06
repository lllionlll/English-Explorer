package io.graduation.haui.ui.image_slider

import android.view.LayoutInflater
import android.view.ViewGroup
import io.graduation.haui.bases.BaseAdapter
import io.graduation.haui.databinding.ItemImageSliderBinding

class ImageSliderAdapter : BaseAdapter<Int, ItemImageSliderBinding>() {

    inner class ImageSliderViewHolder(binding: ItemImageSliderBinding) : BaseViewHolder(binding) {

        override fun setData(item: Int) {
            binding.image.setImageResource(item)
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemImageSliderBinding.inflate(inflater, parent, false)
        binding.root.layoutParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
        return ImageSliderViewHolder(binding)
    }
}