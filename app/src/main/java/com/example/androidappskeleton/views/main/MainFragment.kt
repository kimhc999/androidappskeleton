package com.example.androidappskeleton.views.main

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.androidappskeleton.R
import com.example.androidappskeleton.SkeletonApp
import com.example.androidappskeleton.databinding.FragmentMainBinding
import com.example.androidappskeleton.utils.EventObserver
import javax.inject.Inject


class MainFragment: Fragment() {
    @Inject
    lateinit var viewModel: MainViewModel
    private lateinit var viewDataBinding: FragmentMainBinding
    override fun onAttach(context: Context) {
        (context.applicationContext as SkeletonApp).appComponent.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewDataBinding = DataBindingUtil.inflate<FragmentMainBinding>(
            inflater, R.layout.fragment_main, container, false).apply {
            this.viewModel = this@MainFragment.viewModel
            lifecycleOwner = this@MainFragment
        }
        this.viewModel.successEvent.observe(this, EventObserver {
            Log.i("MainFragment", "successEvent $it")
        })
        this.viewModel.failedEvent.observe(this, EventObserver {
            Log.i("MainFragment", "failedEvent")
        })
        return viewDataBinding.root
    }
}