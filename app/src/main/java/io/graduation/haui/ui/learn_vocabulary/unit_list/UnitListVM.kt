package io.graduation.haui.ui.learn_vocabulary.unit_list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.graduation.haui.data.DataResult
import io.graduation.haui.data.model.UnitDetail
import io.graduation.haui.data.repository.EnglishExplorerRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class UnitListVM @Inject constructor(
    private val englishExplorerRepository: EnglishExplorerRepository
) : ViewModel() {

    val isLoading = MutableLiveData<Boolean>()
    val unitList = MutableLiveData<MutableList<UnitDetail>>()

    fun getUnitList() {
        viewModelScope.launch {
            try {
                isLoading.value = true
                val getUnitListResult = withContext(Dispatchers.IO) {
                    englishExplorerRepository.getUnitList()
                }
                if (getUnitListResult is DataResult.Success) {
                    val unitListData = getUnitListResult.data
                    unitList.value = unitListData
                }
                isLoading.value = false
            } catch (e: Exception) {
                isLoading.value = false
            }
        }
    }
}