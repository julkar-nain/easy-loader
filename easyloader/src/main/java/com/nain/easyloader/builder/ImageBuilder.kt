package com.nain.easyloader.builder

import android.widget.ImageView
import com.nain.easyloader.loader.ImageLoader

/**
 * @author julkar nain
 * @since 4/18/19
 */
open class ImageBuilder{

    private val imageLoader = ImageLoader()

    open fun src(url : String) : ImageBuilder{
        imageLoader.url = url;

        return this;
    }

    open fun container(imageView: ImageView) : ImageBuilder{
        imageLoader.imageView = imageView;

        return this;
    }

    open fun build(): ImageLoader{
        return imageLoader
    }
}