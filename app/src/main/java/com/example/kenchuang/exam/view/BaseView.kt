package com.example.kenchuang.exam.view

import android.content.Context
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.v7.widget.CardView
import android.util.AttributeSet
import android.view.View
import com.example.kenchuang.exam.BaseActivity
import kotlinx.android.synthetic.main.activity_base.*

import java.lang.ref.WeakReference

/**
 * Created by ken.chuang on 2019/1/21.
 * Description:
 */
open class BaseView @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    lateinit var binding : ViewDataBinding

}