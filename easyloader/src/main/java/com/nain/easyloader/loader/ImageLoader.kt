package com.nain.easyloader.loader

import android.app.Activity
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.widget.ImageView
import java.io.InputStream

/**
 * @author julkar nain
 * @since 4/18/19
 */
open class ImageLoader : BaseLoader() {
    internal lateinit var imageView: ImageView

    open fun show() {
        download(object : DefaultDataHandler() {
            override fun onSuccess(data: InputStream) {
                super.onSuccess(data)
                val imageData: Bitmap = BitmapFactory.decodeStream(data)
                val activity: Activity = imageView.context as Activity;
                activity.runOnUiThread({ imageView.setImageBitmap(imageData) })
            }
        })
    }
}