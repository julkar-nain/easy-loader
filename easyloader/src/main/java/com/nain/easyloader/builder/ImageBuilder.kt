package com.nain.easyloader.builder

import android.widget.ImageView
import com.nain.easyloader.loader.ImageLoader

/**
 * @author julkar nain
 * @since 4/18/19
 */
open class ImageBuilder : BaseBuilder<ImageBuilder, ImageLoader>(ImageLoader()){

    private val imageLoader : ImageLoader = baseLoader as ImageLoader

    open fun container(imageView: ImageView) : ImageBuilder{
        imageLoader.imageView = imageView

        return this
    }

    open fun placeholder(imageResource: Int) : ImageBuilder{
        imageLoader.placeHolder = imageResource

        return this
    }

    open fun asList(): ImageListBuilder{
        return ImageListBuilder()
    }
}