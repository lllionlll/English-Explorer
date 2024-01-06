package io.graduation.haui.bases

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.viewbinding.ViewBinding
import io.graduation.haui.R

abstract class BaseFragment<VB : ViewBinding>(
    private val bindingInflate: (LayoutInflater) -> VB
) : Fragment() {

    val binding by lazy { bindingInflate(layoutInflater) }

    private val callback = object : OnBackPressedCallback(false) {
        override fun handleOnBackPressed() {
            requireActivity().findNavController(R.id.nav_host_fragment).popBackStack()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initData()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        observerData()
        initView()
        handleEvent()
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner , object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                findNavController().navigateUp()
            }
        })
        return binding.root
    }

    open fun initData() {

    }

    open fun initView() {

    }

    open fun handleEvent() {

    }

    open fun observerData() {

    }

}