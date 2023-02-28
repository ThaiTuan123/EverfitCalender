package com.example.everfittest.ui

import android.view.LayoutInflater
import com.example.everfittest.base.BaseActivity
import com.example.everfittest.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {
    override fun inflateViewBinding(inflater: LayoutInflater) =
        ActivityMainBinding.inflate(inflater)

    override fun initView() {
    }

    override fun initData() {
        // TODO
    }

    override fun getViewModelClass(): Class<MainViewModel> {
        return MainViewModel::class.java
    }
}