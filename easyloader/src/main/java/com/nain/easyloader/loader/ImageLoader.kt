package com.nain.easyloader.loader

import android.app.Activity
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.widget.ImageView
import com.nain.easyloader.cache.MemoryCache
import com.nain.easyloader.handler.DefaultDataHandler
import java.io.InputStream

/**
 * @author julkar nain
 * @since 4/18/19
 */
open class ImageLoader : BaseLoader() {
    internal lateinit var imageView: ImageView
    internal var placeHolder: Int = 0

    open fun show() {
        val activity: Activity = imageView.context as Activity
        imageView.setImageDrawable(activity.getDrawable(placeHolder))

        val bitmap: Bitmap? = MemoryCache.get(url) as Bitmap?

        if (bitmap != null) {
            activity.runOnUiThread({ imageView.setImageBitmap(bitmap) })
        } else {
            download(object : DefaultDataHandler() {
                override fun onSuccess(data: InputStream) {
                    super.onSuccess(data)
                    val imageData: Bitmap = BitmapFactory.decodeStream(data)
                    MemoryCache.set(url, imageData)
                    activity.runOnUiThread({ imageView.setImageBitmap(imageData) })
                }
            })
        }
    }
}