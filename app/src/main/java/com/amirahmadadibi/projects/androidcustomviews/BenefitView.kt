package com.amirahmadadibi.projects.androidcustomviews

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView

/**
 * Created by Amirahmad Adibi.
 * AndroidCustomViews | Copyrights 2019-10-20.
 */

class BenefitView(context: Context, attributeSet: AttributeSet) :
    LinearLayout(context, attributeSet) {

    init {
        View.inflate(context,R.layout.benefit_view,this)

        val imageView = findViewById<ImageView>(R.id.imageViewCustom)
        val textView = findViewById<TextView>(R.id.textViewCustom)

        val attributeSet = context.obtainStyledAttributes(attributeSet,R.styleable.BenefitView)
        imageView.setImageDrawable(attributeSet.getDrawable(R.styleable.BenefitView_image_background))
        textView.text = attributeSet.getString(R.styleable.BenefitView_text_custom)
        attributeSet.recycle()
    }


}