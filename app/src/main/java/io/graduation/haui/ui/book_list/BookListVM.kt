package io.graduation.haui.ui.book_list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.graduation.haui.data.DataResult
import io.graduation.haui.data.model.BookDetail
import io.graduation.haui.data.repository.EnglishExplorerRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class BookListVM @Inject constructor(
    private val englishExplorerRepository: EnglishExplorerRepository
) : ViewModel() {

    val isLoading = MutableLiveData<Boolean>()
    val bookDetailList = MutableLiveData<MutableList<BookDetail>>()

    fun getBookList() {
        viewModelScope.launch {
            try {
                isLoading.value = true
                val getBookListResult = withContext(Dispatchers.IO) {
                    englishExplorerRepository.getBookList()
                }
                if (getBookListResult is DataResult.Success) {
                    val bookListData = getBookListResult.data
                    bookDetailList.value = bookListData
                }
                isLoading.value = false
            } catch (e: Exception) {
                isLoading.value = false
            }
        }
    }
}