package com.example.kenchuang.exam

/**
 * Created by ken.chuang on 2018/11/23.
 * Description:
 */
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.os.PersistableBundle
import android.support.annotation.LayoutRes
import android.support.annotation.VisibleForTesting
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.MotionEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import com.example.kenchuang.exam.R.id.base_content
import com.example.kenchuang.exam.activity.viewmodel.BaseViewModel
import kotlinx.android.synthetic.main.activity_base.*

import java.lang.ref.WeakReference
import java.util.HashMap
import kotlin.reflect.KClass

abstract class BaseActivity<VM: BaseViewModel> : AppCompatActivity() {

    protected lateinit var model : VM
    protected lateinit var weakSelf: WeakReference<BaseActivity<VM>>
    lateinit var binding : ViewDataBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        weakSelf = WeakReference(this)

        binding = DataBindingUtil.setContentView(weakSelf.get()!!, getLayoutId())
        base_content?.setOnTouchListener { _, _ ->
            hideKeyboard()
            false
        }
    }

    @LayoutRes
    open fun getLayoutId(): Int {
        return R.layout.activity_base
    }

    override fun getLayoutInflater(): LayoutInflater {
        return super.getLayoutInflater()
    }


    protected fun hideKeyboard() {
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(this.currentFocus?.windowToken, 0)
    }

}