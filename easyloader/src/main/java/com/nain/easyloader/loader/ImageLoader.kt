package com.nain.easyloader.loader

import android.app.Activity
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.widget.ImageView
import com.nain.easyloader.cache.MemoryCache
import com.nain.easyloader.handler.DataHandler
import com.nain.easyloader.handler.DefaultDataHandler
import com.nain.easyloader.task.CancellableTask
import java.io.InputStream

/**
 * @author julkar nain
 * @since 4/18/19
 */
open class ImageLoader : BaseLoader() {
    internal lateinit var imageView: ImageView
    internal var placeHolder: Int = 0

    open fun show() : CancellableTask {
        val activity: Activity = imageView.context as Activity
        if(placeHolder != 0) {
            imageView.setImageDrawable(activity.getDrawable(placeHolder))
        }

        val bitmap: Bitmap? = MemoryCache.get(url) as Bitmap?

        if (bitmap != null) {
            activity.runOnUiThread({ imageView.setImageBitmap(bitmap) })
        } else {
            download(object : DefaultDataHandler() {
                override fun onSuccess(data: Any) {
                    super.onSuccess(data)
                    val imageData: Bitmap = BitmapFactory.decodeStream(data as InputStream)
                    MemoryCache.set(url, imageData)
                    activity.runOnUiThread({ imageView.setImageBitmap(imageData) })
                }
            })
        }

        return this
    }

    open fun loadBitmap(dataHandler: DataHandler): CancellableTask{
        val bitmap: Bitmap? = MemoryCache.get(url) as Bitmap?

        if (bitmap != null) {
           dataHandler.onSuccess(bitmap)
        } else {
            download(object : DefaultDataHandler() {
                override fun onSuccess(data: Any) {
                    super.onSuccess(data)
                    val imageData: Bitmap? = BitmapFactory.decodeStream(data as InputStream)
                    MemoryCache.set(url, imageData as Bitmap)
                    dataHandler.onSuccess(imageData)
                }

                override fun onFailure(error: Any) {
                    super.onFailure(error)
                    dataHandler.onFailure(error)
                }
            })
        }

        return this
    }
}