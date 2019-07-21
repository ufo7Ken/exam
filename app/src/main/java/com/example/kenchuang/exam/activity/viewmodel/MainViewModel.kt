package com.example.kenchuang.exam.activity.viewmodel

import android.app.Application
import android.arch.lifecycle.MutableLiveData
import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.WindowManager
import android.util.DisplayMetrics
import android.view.View
import com.example.kenchuang.exam.activity.GameAcitivty
import com.example.kenchuang.exam.data.GameDataCenter


class MainViewModel(application : Application)  : BaseViewModel(application) {

    val MIN_BUTTON_WIDTH_HEIGHT = 48 //dp

    var row_text = MutableLiveData<String>()
    var column_text = MutableLiveData<String>()
    var row_errormsg = MutableLiveData<String>()
    var column_errormsg = MutableLiveData<String>()

    var max_row :Int = 0
    var max_column :Int = 0

    init {
        calMaxRowMaxColumn(application)
    }

    fun onColumnTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
        if(s.length <= 0)
            return

        val number = s.toString().toInt()

        if(number <= 0)
        {
            column_errormsg.postValue("請輸入0~$max_column")
        }else if(number > max_column) {
            column_text.postValue("")
            column_errormsg.postValue("請輸入0~$max_column")
        }else {
            Log.w("tag", "column "+column_text )
            column_errormsg.postValue("")
        }
    }


    fun onRowTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
        if(s.length <= 0)
            return

        val number = s.toString().toInt()

        if(number <= 0)
        {
            row_errormsg.postValue("請輸入1~$max_row")
        }else if(number > max_row) {
            row_text.postValue("")
            row_errormsg.postValue("請輸入1~$max_row")
        }else {
            Log.w("tag", "row "+row_text )
            row_errormsg.postValue("")
        }
    }


    fun sendForm(v: View)
    {
        GameDataCenter.intance.input_column = column_text.value.toString().toInt()
        GameDataCenter.intance.input_row = row_text.value.toString().toInt()
        Log.w("tag", "GameDataCenter.input_column "+GameDataCenter.intance.input_column )
        Log.w("tag", "GameDataCenter.input_row "+GameDataCenter.intance.input_row )

            val context = v.context
            val intent = Intent(context, GameAcitivty::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            context.startActivity(intent)

    }

    private fun calMaxRowMaxColumn(application : Application) {
        val wm = application.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val dm = DisplayMetrics()
        wm.defaultDisplay.getMetrics(dm)
        val width = dm.widthPixels// 屏幕宽度（像素）
        val height = dm.heightPixels // 屏幕高度（像素）
        val density = dm.density//屏幕密度（0.75 / 1.0 / 1.5）
        val densityDpi = dm.densityDpi//屏幕密度dpi（120 / 160 / 240）
        //屏幕宽度算法:屏幕宽度（像素）/屏幕密度
        val screenWidth = (width / density).toInt()//屏幕宽度(dp)
        val screenHeight = (height / density).toInt()//屏幕高度(dp)

        max_column = screenWidth / MIN_BUTTON_WIDTH_HEIGHT -1 //one column for button
        max_row = screenHeight / MIN_BUTTON_WIDTH_HEIGHT
    }


    fun reset() {
        row_text.postValue("")
        column_text.postValue("")
        row_errormsg.postValue("")
        column_errormsg.postValue("")
    }
}