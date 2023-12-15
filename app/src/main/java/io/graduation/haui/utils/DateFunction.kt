package io.graduation.haui.utils

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

object DateFunction {

    fun getCurrentDateTime(): String {
        val dateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
        val date = Date()
        return dateFormat.format(date)
    }


}