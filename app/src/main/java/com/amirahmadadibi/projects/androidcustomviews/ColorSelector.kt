package com.amirahmadadibi.projects.androidcustomviews

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.widget.LinearLayout
import java.time.format.DecimalStyle
import java.util.jar.Attributes

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
    @JvmOverloads//
    constructor(
        context: Context,
        attributesSet: AttributeSet? = null,
        defStyle: Int = 0,
        defRes: Int = 0
    ) : super(context, attributesSet, defStyle, defRes)

    private var listOfColors = listOf(Color.BLUE,Color.RED,Color.GREEN)
    private var selectedColorIndex = 0
    //it gets run no matter of constructors
    init {
        orientation = HORIZONTAL
    }


}