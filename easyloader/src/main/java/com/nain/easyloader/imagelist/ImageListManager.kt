package com.nain.easyloader.imagelist

import android.app.Activity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import java.lang.Exception

open class ImageListManager {
    internal lateinit var recyclerView : RecyclerView
    internal lateinit var dataHolder : List<String>

    open fun show(){
        (recyclerView.context as Activity).runOnUiThread({recyclerView.adapter = ListAdapter(dataHolder)
            recyclerView.layoutManager = LinearLayoutManager(recyclerView.context)})
    }
}