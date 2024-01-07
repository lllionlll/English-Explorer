package io.graduation.haui.ui.menu

import io.graduation.haui.bases.BaseFragment
import io.graduation.haui.databinding.FragmentMenuListBinding

class MenuFragment : BaseFragment<FragmentMenuListBinding>(
    FragmentMenuListBinding::inflate
) {

    override fun handleEvent() {
        super.handleEvent()
        binding.learnVocabulary.setOnClickListener {
            MenuRoute.goToUnit(this)
        }
        binding.learnSpeak.setOnClickListener {
            MenuRoute.goToSpeechToText(this)
        }
    }

}