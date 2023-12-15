package io.graduation.haui.data.model

import com.google.firebase.firestore.PropertyName

data class BookDetail(
    @set:PropertyName("book") @get:PropertyName("book") var book: Int? = null,
    @set:PropertyName("book_name") @get:PropertyName("book_name") var bookName: String? = null,
    @set:PropertyName("book_img") @get:PropertyName("book_img") var bookImg: String? = null
)