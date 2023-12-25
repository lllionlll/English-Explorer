package io.graduation.haui.ui.vocabulary_list

import android.view.LayoutInflater
import android.view.ViewGroup
import io.graduation.haui.bases.BaseAdapter
import io.graduation.haui.data.model.WordDetail
import io.graduation.haui.databinding.ItemVocabularyBinding

class VocabularyListAdapter : BaseAdapter<WordDetail, ItemVocabularyBinding>() {

    inner class VocabularyViewHolder(binding: ItemVocabularyBinding) : BaseViewHolder(binding) {

        override fun setData(item: WordDetail) {
            binding.unitName.text = item.word
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VocabularyViewHolder {
        val inflate = LayoutInflater.from(parent.context)
        val binding = ItemVocabularyBinding.inflate(inflate, parent, false)
        return VocabularyViewHolder(binding)
    }

}