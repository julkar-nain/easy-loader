package com.nain.easyloader.builder

import android.animation.PropertyValuesHolder
import android.support.v7.widget.RecyclerView
import com.nain.easyloader.imagelist.ImageListManager

open class ImageListBuilder{
  private val imageListManager : ImageListManager = ImageListManager()

  open fun container(recyclerView: RecyclerView) : ImageListBuilder{
    imageListManager.recyclerView = recyclerView

    return this
  }

  open fun src(dataHolder: List<String>): ImageListBuilder{
    imageListManager.dataHolder = dataHolder

    return this
  }

  open fun build(): ImageListManager{
    return imageListManager
  }
}