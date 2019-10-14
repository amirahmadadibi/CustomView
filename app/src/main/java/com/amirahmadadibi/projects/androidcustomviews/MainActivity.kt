package com.amirahmadadibi.projects.androidcustomviews

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        colorSelector.setColorSelectorListener(object : IColorSelectorListener{
//            override fun onColorSelected(selectedColor: Int) {
//                Toast.makeText(this@MainActivity,"ui represent",Toast.LENGTH_LONG).show()
//                Log.d("tagxx", "${selectedColor}")
//
//            }
//        })

        colorSelector.setOnChoseListener {
            Log.d("tagxx", "${it}")
        }
    }
}
