package io.graduation.haui.ui.unit_list

import android.view.LayoutInflater
import android.view.ViewGroup
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
            binding.unitName.text = String.format(
                "Unit %s: %s",
                item.unit.toString(),
                item.unitName
            )
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VocabularyUnitViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemUnitBinding.inflate(inflater, parent, false)
        return VocabularyUnitViewHolder(binding)
    }

}