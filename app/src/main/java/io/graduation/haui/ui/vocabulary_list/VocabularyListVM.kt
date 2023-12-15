package io.graduation.haui.ui.vocabulary_list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.graduation.haui.data.DataResult
import io.graduation.haui.data.model.WordDetail
import io.graduation.haui.data.repository.EnglishExplorerRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class VocabularyListVM @Inject constructor(
    private val englishExplorerRepository: EnglishExplorerRepository
): ViewModel() {

    val isLoading = MutableLiveData<Boolean>()
    val vocabularyList = MutableLiveData<MutableList<WordDetail>>()

    fun getVocabularyList(
        book: Int,
        unit: Int
    ) {
        viewModelScope.launch {
            try {
                isLoading.value = true
                val getVocabularyResult = withContext(Dispatchers.IO) {
                    englishExplorerRepository.getVocabularyListByBookAndUnit(
                        book = book,
                        unit = unit
                    )
                }
                if (getVocabularyResult is DataResult.Success) {
                    val vocabularyListData = getVocabularyResult.data
                    vocabularyList.value = vocabularyListData
                }
                isLoading.value = false
            } catch (e: Exception) {
                isLoading.value = false
            }
        }
    }
}