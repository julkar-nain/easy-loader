package com.nain.easyloader

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sampleImageUrlForUpper = "https://images.unsplash.com/photo-1464547323744-4edd0cd0c746?ixlib=rb-0.3.5&q=80&fm=jpg&crop=entropy&w=1080&fit=max&s=c990dc1cd803124b9e6c43b97c844ad3"
        val sampleImageUrlForLower = "https://images.unsplash.com/photo-1464550883968-cec281c19761?ixlib=rb-0.3.5&q=80&fm=jpg&crop=entropy&w=1080&fit=max&s=1881cd689e10e5dca28839e68678f432"

        EasyLoader
            .imageBuilder()
            .src(sampleImageUrlForUpper)
            .placeholder(R.drawable.placeholder)
            .container(imageViewUpper)
            .build()
            .show()

        EasyLoader
            .imageBuilder()
            .src(sampleImageUrlForLower)
            .placeholder(R.drawable.placeholder)
            .container(imageViewLower)
            .build()
            .show()

    }
}