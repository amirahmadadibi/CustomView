package com.amirahmadadibi.projects.androidcustomviews

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() , IColorSelectorListener{
    override fun onColorSelected(selectedColor: Int) {
        Toast.makeText(this,selectedColor.toString(),Toast.LENGTH_LONG).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        colorSelector.setColorSelectorListener(this)
    }
}
