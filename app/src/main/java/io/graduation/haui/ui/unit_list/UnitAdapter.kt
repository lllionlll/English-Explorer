package io.graduation.haui.ui.unit_list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.graduation.haui.data.model.UnitDetail
import io.graduation.haui.databinding.ItemUnitBinding

class UnitAdapter(
    val openUnit: (Int) -> Unit = {}
) : RecyclerView.Adapter<UnitAdapter.VocabularyUnitViewHolder>() {

    private var unitList = mutableListOf<UnitDetail>()

    inner class VocabularyUnitViewHolder(private val binding: ItemUnitBinding) : RecyclerView.ViewHolder(binding.root) {
        init {
            binding.root.setOnClickListener {
                openUnit.invoke(layoutPosition)
            }
        }

        fun setData(unitDetail: UnitDetail) {
            binding.unitName.text = String.format(
                "Unit %s: %s",
                unitDetail.unit.toString(),
                unitDetail.unitName
            )
        }
    }

    fun addUnitList(unitList: MutableList<UnitDetail>) {
        this.unitList = unitList
        notifyItemRangeInserted(0, unitList.size)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VocabularyUnitViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemUnitBinding.inflate(inflater, parent, false)
        return VocabularyUnitViewHolder(binding)
    }

    override fun onBindViewHolder(holder: VocabularyUnitViewHolder, position: Int) {
        unitList.getOrNull(position)?.let { unitDetail ->
            holder.setData(unitDetail)
        }
    }

    override fun getItemCount(): Int {
        return unitList.size
    }
}