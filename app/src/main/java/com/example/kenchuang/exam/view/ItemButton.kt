package com.example.kenchuang.exam.view

import android.content.Context
import android.databinding.DataBindingUtil
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kenchuang.exam.R
import com.example.kenchuang.exam.data.GameDataCenter
import com.example.kenchuang.exam.databinding.ItemButtonBinding

class ItemButton@JvmOverloads constructor(
        parent: ViewGroup, context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : BaseView(context, attrs, defStyleAttr) {

    var indexColumn: Int = 0

    init {
        binding = DataBindingUtil.inflate(
                LayoutInflater.from(context),
                R.layout.item_button,
                parent,
                false)

        (binding as ItemButtonBinding).data = GameDataCenter.intance
        (binding as ItemButtonBinding).vm = BaseViewModel()
    }

}