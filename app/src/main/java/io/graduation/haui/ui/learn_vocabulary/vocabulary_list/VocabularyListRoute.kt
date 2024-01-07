package io.graduation.haui.ui.learn_vocabulary.vocabulary_list

import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

object VocabularyListRoute {

    fun back(fragment: Fragment) {
        fragment.findNavController().popBackStack()
    }

}