package com.example.kenchuang.exam.view

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.util.Log
import android.view.View
import com.example.kenchuang.exam.data.GameDataCenter
import com.example.kenchuang.exam.databinding.ItemButtonBinding

class BaseViewModel : ViewModel(){
    var indexRow = MutableLiveData<Int>().apply { value = 0 }
    var indexColumn = MutableLiveData<Int>().apply { value = 0 }

    fun onClear(view : View)
    {
        GameDataCenter.intance.resetGameLayout()
        Log.w("tag", "indexColumn $indexColumn indexRow indexRow" )

    }
}