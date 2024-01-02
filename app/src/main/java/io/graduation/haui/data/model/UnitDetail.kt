package io.graduation.haui.data.model

import com.google.firebase.firestore.PropertyName

data class UnitDetail(
    @set:PropertyName("unit") @get:PropertyName("unit") var unit: Int? = null,
    @set:PropertyName("unit_name") @get:PropertyName("unit_name") var unitName: String? = null,
    @set:PropertyName("unit_image") @get:PropertyName("unit_image") var unitImage: String? = null
)