package com.example.kenchuang.exam.view

import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.databinding.DataBindingUtil
import android.support.constraint.ConstraintLayout
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kenchuang.exam.R
import com.example.kenchuang.exam.activity.viewmodel.MainViewModel
import com.example.kenchuang.exam.data.GameDataCenter
import com.example.kenchuang.exam.databinding.ItemColumnGroupBinding

class ItemColumnGroup @JvmOverloads constructor(
         parent: ViewGroup, context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : BaseView(context, attrs, defStyleAttr){

    var indexColumn : Int = 0
    init {
        binding = DataBindingUtil.inflate(
                LayoutInflater.from(context),
                R.layout.item_column_group,
                parent,
                false)

        (binding as ItemColumnGroupBinding).data = GameDataCenter.intance
        (binding as ItemColumnGroupBinding).vm = BaseViewModel()
    }

}