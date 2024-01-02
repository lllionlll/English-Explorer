package io.graduation.haui.ui.learn_vocabulary.vocabulary_list

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import dagger.hilt.android.AndroidEntryPoint
import io.graduation.haui.bases.BaseFragment
import io.graduation.haui.databinding.FragmentVocabularyListBinding
import io.graduation.haui.utils.LoadingDialog

@AndroidEntryPoint
class VocabularyListFragment : BaseFragment<FragmentVocabularyListBinding>(
    FragmentVocabularyListBinding::inflate
) {

    private val vocabularyListVM by viewModels<VocabularyListVM>()
    private val safeVarargs by navArgs<VocabularyListFragmentArgs>()

    private val vocabularyListAdapter = VocabularyListAdapter()

    override fun initData() {
        super.initData()
        binding.rcVocabularyList.adapter = vocabularyListAdapter
        binding.rcVocabularyList.itemAnimator = null
        vocabularyListVM.getVocabularyList(
            unitId = safeVarargs.unitId
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
                vocabularyListAdapter.setItemList(itemList = vocabularyList)
            }
        }

    }
}