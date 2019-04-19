package com.nain.easyloader

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        EasyLoader
            .imageBuilder()
            .src(SAMPLE_IMAGE_1)
            .placeholder(R.drawable.placeholder)
            .container(imageViewUpper)
            .cacheLimit(1)
            .build()
            .show()

        EasyLoader
            .imageBuilder()
            .src(SAMPLE_IMAGE_2)
            .placeholder(R.drawable.placeholder)
            .container(imageViewLower)
            .cacheLimit(1)
            .build()
            .show()

    }

    override fun onDestroy() {
        super.onDestroy()
        EasyLoader.clearCache()
    }
}