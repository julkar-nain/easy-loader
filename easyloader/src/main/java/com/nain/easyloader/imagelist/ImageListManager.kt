package com.nain.easyloader.imagelist

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView

open class ImageListManager {
    internal lateinit var recyclerView : RecyclerView
    internal lateinit var dataHolder : List<String>

    open fun show(){
        recyclerView.adapter = ListAdapter(dataHolder)
        recyclerView.layoutManager = LinearLayoutManager(recyclerView.context)
    }
}