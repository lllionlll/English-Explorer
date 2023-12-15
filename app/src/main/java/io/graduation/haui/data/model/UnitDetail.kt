package io.graduation.haui.data.model

import com.google.firebase.firestore.PropertyName

data class UnitDetail(
    @set: PropertyName("book") @get:PropertyName("book") var book: Int? = null,
    @set: PropertyName("unit") @get:PropertyName("unit") var unit: Int? = null,
    @set: PropertyName("unit_name") @get:PropertyName("unit_name") var unitName: String? = null,
)