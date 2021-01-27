package com.parkjin.graphql_sample.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.parkjin.graphql_sample.R
import com.parkjin.graphql_sample.databinding.ActivityMainBinding
import com.parkjin.graphql_sample.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.ext.android.getViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.performDataBinding()
    }

    private fun performDataBinding() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = getViewModel(MainViewModel::class)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        binding.executePendingBindings()
    }

    override fun onResume() {
        super.onResume()
        viewModel.getFeeds()
    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel.disposable.clear()
    }
}