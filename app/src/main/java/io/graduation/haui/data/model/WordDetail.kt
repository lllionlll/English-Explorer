package io.graduation.haui.data.model

import com.google.firebase.firestore.PropertyName

data class WordDetail(
    @set:PropertyName("audio") @get:PropertyName("audio") var audio: String? = null,
    @set:PropertyName("book") @get:PropertyName("book") var book: Int? = null,
    @set:PropertyName("description") @get:PropertyName("description") var description: String? = null,
    @set:PropertyName("example") @get:PropertyName("example") var example: String? = null,
    @set:PropertyName("word_type") @get:PropertyName("word_type") var wordType: String? = null,
    @set:PropertyName("image") @get:PropertyName("image") var image: String? = null,
    @set:PropertyName("international") @get:PropertyName("international") var international: String? = null,
    @set:PropertyName("unit") @get:PropertyName("unit") var unit: Int? = null,
    @set:PropertyName("translate") @get:PropertyName("translate") var translate: String? = null,
    @set:PropertyName("word") @get:PropertyName("word") var word: String? = null
)
