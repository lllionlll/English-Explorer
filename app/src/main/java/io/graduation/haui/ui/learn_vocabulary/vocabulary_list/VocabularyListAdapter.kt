package io.graduation.haui.ui.learn_vocabulary.vocabulary_list

import android.view.LayoutInflater
import android.view.ViewGroup
import com.bumptech.glide.Glide
import io.graduation.haui.bases.BaseAdapter
import io.graduation.haui.data.model.WordDetail
import io.graduation.haui.databinding.ItemVocabularyBinding

class VocabularyListAdapter : BaseAdapter<WordDetail, ItemVocabularyBinding>() {

    inner class VocabularyViewHolder(binding: ItemVocabularyBinding) : BaseViewHolder(binding) {

        override fun setData(item: WordDetail) {
            binding.word.text = item.word
            binding.internationalPhonetic.text = item.internationalPhonetic
            binding.wordType.text = item.wordType
            binding.description.text = item.description
            binding.example.text = item.example
            Glide.with(binding.wordImage.context)
                .load(item.image)
                .into(binding.wordImage)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VocabularyViewHolder {
        val inflate = LayoutInflater.from(parent.context)
        val binding = ItemVocabularyBinding.inflate(inflate, parent, false)
        return VocabularyViewHolder(binding)
    }

}