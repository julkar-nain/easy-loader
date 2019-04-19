package com.nain.easyloader.builder

import com.nain.easyloader.loader.JsonLoader

open class JsonBuilder : BaseBuilder<JsonBuilder, JsonLoader>(JsonLoader()){

    private val jsonLoader = baseLoader as JsonLoader
}