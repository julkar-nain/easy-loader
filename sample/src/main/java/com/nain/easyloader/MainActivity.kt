package com.nain.easyloader

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.nain.easyloader.handler.DefaultDataHandler
import com.nain.easyloader.task.CancellableTask
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
            .build()
            .show()

        val cancellableTask: CancellableTask = EasyLoader
            .imageBuilder()
            .src(SAMPLE_IMAGE_2)
            .placeholder(R.drawable.placeholder)
            .container(imageViewLower)
            .build()
            .show()

        cancellableTask.cancelTask()

        //cancellableTask.cancelTask() can be called in any time for cancel the loading

        val arrayList = ArrayList<String>()

        for (i in 1..100){
            arrayList.add("https://placehold.it/400x400&text=image"+i)
        }

        EasyLoader
            .imageBuilder()
            .cacheLimit(100)
            .asList()
            .src(arrayList)
            .container(recyclerView)
            .build()
            .show()

        EasyLoader
            .jsonBuilder()
            .src(SAMPLE_JSON_1)
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
        EasyLoader.cancelAllTasks()
    }
}