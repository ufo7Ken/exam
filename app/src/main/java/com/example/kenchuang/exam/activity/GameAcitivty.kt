package com.example.kenchuang.exam.activity

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.view.ViewStub
import android.widget.Toast
import com.example.kenchuang.exam.BaseActivity
import com.example.kenchuang.exam.R
import com.example.kenchuang.exam.data.GameDataCenter
import com.example.kenchuang.exam.databinding.ActivityGameBinding
import com.example.kenchuang.exam.activity.viewmodel.GameViewModel
import com.example.kenchuang.exam.databinding.ViewStubInflateBinding
import kotlinx.android.synthetic.main.activity_game.*

class GameAcitivty : BaseActivity<GameViewModel>() {

    override fun getLayoutId(): Int {
        return R.layout.activity_game
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        model = ViewModelProviders.of(this).get(GameViewModel::class.java)
        (binding as ActivityGameBinding).vm = model
        (binding as ActivityGameBinding).data = GameDataCenter.intance
        binding.setLifecycleOwner(this)

        (binding as ActivityGameBinding).stubImport.setOnInflateListener{
            stub, inflated->
                var viewBind :ViewDataBinding = DataBindingUtil.bind(inflated)!!
            (viewBind as ViewStubInflateBinding).data = GameDataCenter.intance
        }



        Thread(Runnable {
            // performing some dummy time taking operation
            this.runOnUiThread( java.lang.Runnable{
                (binding as ActivityGameBinding).stubImport.viewStub!!.inflate()
            })


            // try to touch View of UI thread
//            this@MainActivity.runOnUiThread(java.lang.Runnable {
//                this.textview_msg.text = "Updated from other Thread"
//            })
        }).start()

    }

    override fun onDestroy() {
        GameDataCenter.intance.stopGame()
        if (!isFinishing) { //isFinishing will be false in case of orientation change
            Toast.makeText(application, "请重新输入 column 及 row", Toast.LENGTH_SHORT).show()
            finish()
            super.onDestroy()
        }else{
            super.onDestroy()
        }
    }
}