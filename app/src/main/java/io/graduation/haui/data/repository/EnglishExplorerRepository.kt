package io.graduation.haui.data.repository

import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import io.graduation.haui.data.ApiException
import io.graduation.haui.data.ApiSuccess
import io.graduation.haui.data.DataResult
import io.graduation.haui.data.handleFirebaseTask
import io.graduation.haui.data.model.BookDetail
import io.graduation.haui.data.model.UnitDetail
import io.graduation.haui.data.model.WordDetail

class EnglishExplorerRepository {

    private val fb = FirebaseFirestore.getInstance()

    fun getVocabularyListByUnit(
        unitId: Int
    ): DataResult<MutableList<WordDetail>> {
        return try {
            val getVocabularyList = fb.collection("word_list")
                .whereEqualTo("unit", unitId)
                .orderBy("word", Query.Direction.ASCENDING)
                .get()

            when (val handleFirebaseResult = handleFirebaseTask(getVocabularyList)) {

                is ApiSuccess -> {
                    val vocabularyList = handleFirebaseResult.data.toObjects(WordDetail::class.java)
                    DataResult.Success(vocabularyList)
                }

                is ApiException -> {
                    val message = handleFirebaseResult.e.message
                    DataResult.Error(message = message)
                }

                else -> {
                    DataResult.Error()
                }
            }
        } catch (e: Exception) {
            DataResult.Error(message = e.message)
        }
    }

    fun getUnitList(): DataResult<MutableList<UnitDetail>> {
        return try {
            val getUnitList = fb.collection("unit_list")
                .orderBy("unit", Query.Direction.ASCENDING)
                .get()

            when (val handleFirebaseResult = handleFirebaseTask(getUnitList)) {

                is ApiSuccess -> {
                    val wordList = handleFirebaseResult.data.toObjects(UnitDetail::class.java)
                    DataResult.Success(wordList)
                }

                is ApiException -> {
                    val message = handleFirebaseResult.e.message
                    DataResult.Error(message = message)
                }

                else -> {
                    DataResult.Error()
                }
            }
        } catch (e: Exception) {
            DataResult.Error(message = e.message)
        }
    }

    fun getBookList(): DataResult<MutableList<BookDetail>> {
        return try {
            val getBookList = fb.collection("book_list")
                .orderBy("book", Query.Direction.ASCENDING).get()

            when (val handleFirebaseResult = handleFirebaseTask(getBookList)) {

                is ApiSuccess -> {
                    val bookDetailList = handleFirebaseResult.data.toObjects(BookDetail::class.java)
                    DataResult.Success(bookDetailList)
                }

                is ApiException -> {
                    val message = handleFirebaseResult.e.message
                    DataResult.Error(message = message)
                }

                else -> {
                    DataResult.Error()
                }
            }
        } catch (e: Exception) {
            DataResult.Error(message = e.message)
        }
    }
}