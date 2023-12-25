package io.graduation.haui.bases

import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkRequest
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.viewbinding.ViewBinding
import io.graduation.haui.R

abstract class BaseActivity<VB : ViewBinding>(private val bindingInflater: (LayoutInflater) -> VB) :
    AppCompatActivity() {

    val binding by lazy { bindingInflater(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val connectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkRequest = NetworkRequest.Builder().build()
        connectivityManager.registerNetworkCallback(networkRequest, object : ConnectivityManager.NetworkCallback() {
            override fun onAvailable(network: Network) {

            }

            override fun onLost(network: Network) {

            }
        })
        initData()
        initView()
        handleEvent()
        bindData()
    }

    open fun initData() {

    }

    open fun initView() {

    }

    open fun handleEvent() {

    }

    open fun bindData() {

    }

}