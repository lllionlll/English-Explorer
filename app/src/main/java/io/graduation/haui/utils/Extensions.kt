package io.graduation.haui.utils

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController

fun Fragment.navigate(from: Int, to: Int, isReplace: Boolean = true, bundle: Bundle? = null) {
    if (isReplace) {
        val navOptions = NavOptions.Builder()
            .setPopUpTo(from, true)
            .build()
        findNavController().navigate(to, bundle, navOptions)
    } else {
        findNavController().navigate(to)
    }
}