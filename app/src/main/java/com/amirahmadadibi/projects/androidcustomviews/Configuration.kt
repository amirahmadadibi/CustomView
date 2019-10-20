package com.amirahmadadibi.projects.androidcustomviews

import android.app.Application
import android.R
import io.github.inflationx.calligraphy3.CalligraphyConfig
import io.github.inflationx.calligraphy3.CalligraphyInterceptor
import io.github.inflationx.viewpump.ViewPump
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T



/**
 * Created by Amirahmad Adibi.
 * AndroidCustomViews | Copyrights 2019-10-16.
 */
class Configuration : Application(){
    override fun onCreate() {
        super.onCreate()
        ViewPump.init(
            ViewPump.builder()
                .addInterceptor(
                    CalligraphyInterceptor(
                        CalligraphyConfig.Builder()
                            .setDefaultFontPath("fonts/dana-medium.ttf")
                            .build()
                    )
                )
                .build()
        )
    }
}