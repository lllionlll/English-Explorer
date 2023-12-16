package io.graduation.haui.ui.vocabulary_list

import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import io.graduation.haui.bases.BaseFragment
import io.graduation.haui.databinding.FragmentVocabularyListBinding
import io.graduation.haui.utils.LoadingDialog

@AndroidEntryPoint
class VocabularyListFragment : BaseFragment<FragmentVocabularyListBinding>(
    FragmentVocabularyListBinding::inflate
) {

    override fun onResume() {
        super.onResume()
        //NavGraph.goToUnit(this, 2)
    }

    private val vocabularyListVM by viewModels<VocabularyListVM>()
    private val vocabularyListAdapter = VocabularyListAdapter()

    override fun setUpView() {
        super.setUpView()
        binding.rcVocabularyList.adapter = vocabularyListAdapter
        vocabularyListVM.getVocabularyList(
            book = 1,
            unit = 1
        )
    }

    override fun observerData() {
        super.observerData()

        vocabularyListVM.isLoading.observe(this) { isLoading ->
            if (isLoading) {
                LoadingDialog.showLoading(requireContext())
            } else {
                LoadingDialog.hide()
            }
        }

        vocabularyListVM.vocabularyList.observe(this) { vocabularyList ->
            if (vocabularyList.isNotEmpty()) {
                vocabularyListAdapter.addVocabularyList(vocabularyList = vocabularyList)
            }
        }

    }
}