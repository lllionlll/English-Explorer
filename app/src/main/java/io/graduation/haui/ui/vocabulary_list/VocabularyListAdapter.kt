package io.graduation.haui.ui.vocabulary_list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.graduation.haui.data.model.WordDetail
import io.graduation.haui.databinding.ItemVocabularyBinding

class VocabularyListAdapter(

): RecyclerView.Adapter<VocabularyListAdapter.VocabularyViewHolder>() {

    private var vocabularyList: MutableList<WordDetail> = mutableListOf()

    inner class VocabularyViewHolder(private val binding: ItemVocabularyBinding): RecyclerView.ViewHolder(binding.root) {

        fun setData(wordDetail: WordDetail) {
            binding.unitName.text = wordDetail.word
        }
    }

    fun addVocabularyList(vocabularyList: MutableList<WordDetail>) {
        this.vocabularyList = vocabularyList
        notifyItemRangeInserted(0, vocabularyList.size)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VocabularyViewHolder {
        val inflate = LayoutInflater.from(parent.context)
        val binding = ItemVocabularyBinding.inflate(inflate, parent, false)
        return VocabularyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return vocabularyList.size
    }

    override fun onBindViewHolder(holder: VocabularyViewHolder, position: Int) {
        vocabularyList.getOrNull(position)?.let {   wordDetail ->
            holder.setData(wordDetail = wordDetail)
        }
    }
}