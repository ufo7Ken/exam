package com.example.kenchuang.exam.data

import android.arch.lifecycle.MutableLiveData
import android.databinding.BaseObservable
import android.databinding.ObservableField
import android.graphics.Color
import android.util.Log
import android.view.View
import java.util.*

public class GameDataCenter private constructor(): BaseObservable()  {
    companion object {
        val intance by lazy(LazyThreadSafetyMode.SYNCHRONIZED) { GameDataCenter() }
    }

    var gameReady = ObservableField<Int>(View.INVISIBLE)

    var input_column : Int = 0
    var input_row :Int = 0

    private var mTimer :Timer? = null
    val GAME_PERIOD = 10*1000L
    var random_x = ObservableField<Int>(0)//MutableLiveData<Int>().apply { value = 0 }
    var random_y = ObservableField<Int>(0)//MutableLiveData<Int>().apply { value = 0 }

    var colorLightArray  = ObservableField<IntArray>()
    var colorDarkArray   = ObservableField<IntArray>()

    fun initGame(){
        var lightArray = IntArray(input_row)
        var darkArray = IntArray(input_row)

        val rnd = Random()
        for (i in lightArray.indices) {
            var r = rnd.nextInt(256)
            var g = rnd.nextInt(256)
            var b = rnd.nextInt(256)
            lightArray[i] =  Color.argb(128, r,g,b)
            darkArray[i] =  Color.argb(255, r,g,b)
        }

        colorLightArray.set(lightArray)
        colorDarkArray.set(darkArray)
    }

    fun startGame(){
        val task = object : TimerTask() {
            override fun run() {

                random_x.set((Math.random()* (input_column -1)).toInt()+1) // 1~input_column
                random_y.set( (Math.random()* input_row -1).toInt()+1)

            }
        }
        mTimer = Timer()
        mTimer?.schedule(task, GAME_PERIOD, GAME_PERIOD)
    }

    fun resetGameLayout(){
        Log.w("tag", "reset")
        random_x.set(0) // 1~input_column
        random_y.set(0)
    }

    fun stopGame(){
        mTimer?.cancel()
        mTimer = null
    }

}