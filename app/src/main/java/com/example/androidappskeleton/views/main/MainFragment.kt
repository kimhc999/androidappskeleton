package com.example.androidappskeleton.views.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.androidappskeleton.R
import com.example.androidappskeleton.databinding.FragmentMainBinding
import com.example.androidappskeleton.utils.EventObserver
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment: Fragment() {

    private val viewModel: MainViewModel by viewModels()

    private lateinit var viewDataBinding: FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewDataBinding = DataBindingUtil.inflate<FragmentMainBinding>(
            inflater, R.layout.fragment_main, container, false).apply {
            val viewModel = this@MainFragment.viewModel
            this.viewModel = viewModel
            lifecycleOwner = this@MainFragment
        }
        this.viewModel.successEvent.observe(viewLifecycleOwner, EventObserver {
            Log.i("MainFragment", "successEvent $it")
        })
        this.viewModel.failedEvent.observe(viewLifecycleOwner, EventObserver {
            Log.i("MainFragment", "failedEvent")
        })
        return viewDataBinding.root
    }
}