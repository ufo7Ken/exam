package com.example.kenchuang.exam.activity.viewmodel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.databinding.ObservableField
import android.view.View

/**
 * Created by ken.chuang on 2018/11/29.
 * Description:
 */
abstract class BaseViewModel(application : Application)  : AndroidViewModel(application){

    var progressBarVisible = ObservableField<Int>(View.GONE)

    fun showProgressBar() {progressBarVisible.set(View.VISIBLE)}
    fun hideProgressBar() {progressBarVisible.set(View.GONE)}
}