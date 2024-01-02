package io.graduation.haui.ui.learn_vocabulary.unit_list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import com.bumptech.glide.Glide
import io.graduation.haui.R
import io.graduation.haui.bases.BaseAdapter
import io.graduation.haui.data.model.UnitDetail
import io.graduation.haui.databinding.ItemUnitBinding

class UnitAdapter(
    val onClickUnit: (Int) -> Unit = {}
) : BaseAdapter<UnitDetail, ItemUnitBinding>() {

    inner class VocabularyUnitViewHolder(binding: ItemUnitBinding) : BaseViewHolder(binding) {
        init {
            binding.root.setOnClickListener {
                onClickUnit.invoke(layoutPosition)
            }
        }

        override fun setData(item: UnitDetail) {
            binding.unitName.text = item.unitName
            Glide.with(binding.root)
                .load(R.mipmap.ic_launcher)
                .into(binding.unitImage)
            item.unitImage?.let {
                Glide.with(binding.root)
                    .load(item.unitImage)
                    .into(binding.unitImage)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VocabularyUnitViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemUnitBinding.inflate(inflater, parent, false)
        return VocabularyUnitViewHolder(binding)
    }

}