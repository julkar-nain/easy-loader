package com.nain.easyloader

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.nain.easyloader.handler.DefaultDataHandler
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONArray
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    private val TAG = javaClass.simpleName

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

        EasyLoader
            .jsonBuilder()
            .src(SAMPLE_JSON_1)
            .cacheLimit(1)
            .build()
            .load(object : DefaultDataHandler() {
                override fun onSuccess(data: Any) {
                    super.onSuccess(data)
                    try {
                        val jsonArray = data as JSONArray
                        Log.d(TAG, jsonArray.toString())
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                }

                override fun onFailure(error: Any) {
                    super.onFailure(error)
                    Log.d(TAG, error.toString())
                }
            })

        EasyLoader
            .jsonBuilder()
            .src(SAMPLE_JSON_2)
            .cacheLimit(1)
            .build()
            .load(object : DefaultDataHandler() {
                override fun onSuccess(data: Any) {
                    super.onSuccess(data)
                    try {
                        val jsonArray = data as JSONObject
                        Log.d(TAG, jsonArray.toString())
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                }

                override fun onFailure(error: Any) {
                    super.onFailure(error)
                    Log.d(TAG, error.toString())
                }
            })
    }

    override fun onDestroy() {
        super.onDestroy()
        EasyLoader.clearCache()
    }
}