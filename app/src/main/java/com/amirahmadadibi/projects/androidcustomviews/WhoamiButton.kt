package com.amirahmadadibi.projects.androidcustomviews

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.button_layout.view.*

/**
 * Created by Amirahmad Adibi.
 * AndroidCustomViews | Copyrights 2019-10-16.
 */

class WhoamiButton : LinearLayout {
    var text: String? = null
    var backgroundImageButton: Int? = null
    var backgroundColor:Int? = null

    constructor(context: Context?) : super(context)
    {
        test(null)
    }
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs){
        test(attrs)
    }

    @SuppressLint("CustomViewStyleable")
    constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) : super(context, attrs, defStyleAttr) {
        test(attrs)
    }


    private fun test(attrs:AttributeSet?){
        attrs?.let {
            var typeArray = getContext().obtainStyledAttributes(attrs, R.styleable.WhoamiButtonStyle)
            text = typeArray.getString(R.styleable.WhoamiButtonStyle_text)
            backgroundImageButton = typeArray.getResourceId(R.styleable.WhoamiButtonStyle_background_image,0)
            backgroundColor = typeArray.getColor(R.styleable.WhoamiButtonStyle_color,0)
            typeArray.recycle()
        }

    }

    init {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE)
                as LayoutInflater
        inflater.inflate(R.layout.button_layout, this)
//        whoamiButtonTextview.text = text
//        whoamiButtonImageview.setImageResource(backgroundImageButton!!)
//        whoamiButtonImageview.setBackgroundColor(backgroundColor!!)
    }

}