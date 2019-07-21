package com.example.kenchuang.exam

import android.databinding.BindingAdapter
import android.graphics.Color
import android.os.AsyncTask
import android.support.constraint.ConstraintLayout
import android.support.design.widget.TextInputLayout
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import com.example.kenchuang.exam.data.GameDataCenter
import com.example.kenchuang.exam.databinding.ItemButtonBinding
import com.example.kenchuang.exam.databinding.ItemColumnGroupBinding
import com.example.kenchuang.exam.databinding.ItemCubeBinding
import com.example.kenchuang.exam.view.ItemButton
import com.example.kenchuang.exam.view.ItemColumnGroup
import com.example.kenchuang.exam.view.ItemCube
import kotlinx.android.synthetic.main.item_column_group.view.*


@BindingAdapter("errorText")
fun setErrorMessage(view: TextInputLayout, errorMessage: String?) {
    view.error = errorMessage

}

@BindingAdapter("backgroundColor")
fun bindBackgroundColor(view: View, color: Int) {
    Log.d("tag", "color $color");

    if (null != color && color != 0) {
        view.setBackgroundColor(color)
    }
}

@BindingAdapter("row","column")
fun setGameCube(view: LinearLayout, row: Int, column: Int) {

    GameDataCenter.intance.initGame()
    GameDataCenter.intance.gameReady.set(View.INVISIBLE)

    for(index in 1..column)
    {
        var item  = ItemColumnGroup(view, view.context)
        (item.binding as ItemColumnGroupBinding).vm?.indexColumn!!.value = index


        for( pos in 1..row)
        {
            var cube  = ItemCube(item.binding.root.cubeBox, item.context)
            (cube.binding as ItemCubeBinding).vm?.indexColumn!!.value = index
            (cube.binding as ItemCubeBinding).vm?.indexRow!!.value =pos
            item.binding.root.cubeBox.addView(cube.binding.root) //add cube
        }

        //add bottom button to ItemColumnGroup
        var btn  = ItemButton(item.binding.root.cubeBox, item.context)
        (btn.binding as ItemButtonBinding).vm?.indexColumn!!.value = index
        item.binding.root.cubeBox.addView(btn.binding.root)

        //add cloumn group
        view.addView(item.binding.root)

    }
    GameDataCenter.intance.gameReady.set(View.VISIBLE)
    GameDataCenter.intance.stopGame()
    GameDataCenter.intance.startGame()
}
