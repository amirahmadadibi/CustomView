package com.amirahmadadibi.projects.androidcustomviews

import android.app.WallpaperManager
import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import android.widget.AdapterView
import android.widget.LinearLayout
import com.daimajia.androidanimations.library.Techniques
import com.daimajia.androidanimations.library.YoYo
import kotlinx.android.synthetic.main.color_selected.view.*

/**
 * Created by Amirahmad Adibi.
 * AndroidCustomViews | Copyrights 2019-08-29.
 */

//compound component
//under the hood java is used to instatied our views
//so we user @JvmOverloads because java has no conspet of default value in constructor and it will
//generate all for different constructors
class ColorSelector : LinearLayout {
    //by defining default value we remove constructor overloading
    @JvmOverloads
    constructor(
        context: Context,
        attributesSet: AttributeSet? = null,
        defStyle: Int = 0,
        defRes: Int = 0
    ) : super(context, attributesSet, defStyle, defRes)

    private var onColorSelectedListener: IColorSelectorListener? = null
    private var listOfColors = listOf(Color.BLUE, Color.RED, Color.GREEN)
    private var selectedColorIndex = 0


    fun setColorSelectorListener(onColorSelectedListener : IColorSelectorListener){
        this.onColorSelectedListener = onColorSelectedListener
    }
    //it gets run no matter of constructors
    init {
        orientation = HORIZONTAL

        //we create our views in merge tag in file and we want inflate them in parent layout in this
        //case is linear layout
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE)
                as LayoutInflater

        inflater.inflate(R.layout.color_selected, this)
        selectedColorView.setBackgroundColor(listOfColors[selectedColorIndex])
        colorSelectorArrowLeft.setOnClickListener {
            selectPreviousColor()
            YoYo.with(Techniques.BounceIn).duration(300).repeat(0).playOn(selectedColorView)
        }
        colorSelectorArrowRight.setOnClickListener {
            selectNextColor()
            YoYo.with(Techniques.BounceIn).duration(300).repeat(0).playOn(selectedColorView)
        }
        Log.d("custom", "android custom layout added")
    }

    private fun selectNextColor() {
        if (selectedColorIndex == listOfColors.lastIndex) {
            selectedColorIndex = 0
        } else {
            selectedColorIndex++
        }
        broadcastColor(listOfColors[selectedColorIndex])
        selectedColorView.setBackgroundColor(listOfColors[selectedColorIndex])

    }

    private fun selectPreviousColor() {
        if (selectedColorIndex == 0) {
            selectedColorIndex = listOfColors.lastIndex
        } else {
            selectedColorIndex--
        }
        broadcastColor(listOfColors[selectedColorIndex])
        selectedColorView.setBackgroundColor(listOfColors[selectedColorIndex])

    }

    private fun broadcastColor(color: Int) {
        this.onColorSelectedListener?.onColorSelected(color)
    }
}

interface IColorSelectorListener {
    fun onColorSelected(selectedColor: Int)
}