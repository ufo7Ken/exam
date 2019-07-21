package com.example.kenchuang.exam.activity

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import com.example.kenchuang.exam.databinding.ActivityMainBinding
import android.util.Log
import com.example.kenchuang.exam.BaseActivity
import com.example.kenchuang.exam.R
import com.example.kenchuang.exam.activity.viewmodel.MainViewModel


class MainActivity : BaseActivity<MainViewModel>() {

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        model = ViewModelProviders.of(this).get(MainViewModel::class.java)
        (binding as ActivityMainBinding).vm = model
        binding.setLifecycleOwner(this)

    }

    override fun onResume() {
        super.onResume()
    }





    override fun onDestroy() {
        if (!isFinishing) { //isFinishing will be false in case of orientation change
            model.reset()
            super.onDestroy()
        }else{
            super.onDestroy()
        }
    }

}
