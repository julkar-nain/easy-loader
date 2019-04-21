package com.nain.easyloader.loader

import com.nain.easyloader.cache.MemoryCache
import com.nain.easyloader.handler.DataHandler
import com.nain.easyloader.handler.DefaultDataHandler
import com.nain.easyloader.task.CancellableTask
import org.json.JSONArray
import org.json.JSONObject
import org.json.JSONTokener
import java.io.BufferedReader
import java.io.InputStream


open class JsonLoader : BaseLoader() {

    open fun loadJSON(dataHandler: DataHandler) : CancellableTask {

        val jsonData: Any? = MemoryCache.get(url)

        if (jsonData != null) {
            dataHandler.onSuccess(jsonData)
        } else {
            download(object : DefaultDataHandler() {

                override fun onSuccess(data: Any) {
                    super.onSuccess(data)

                    val jsonString = inputStreamToString(data as InputStream)

                    try {
                        sendJsonData(dataHandler, JSONObject(JSONTokener(jsonString)))
                    } catch (e: Exception) {
                        try {
                            sendJsonData(dataHandler, JSONArray(JSONTokener(jsonString)))
                        } catch (e: Exception) {
                            e.printStackTrace()
                            dataHandler.onFailure(e)
                        }
                    }
                }

                override fun onFailure(error: Any) {
                    super.onFailure(error)
                    dataHandler.onFailure(error)
                }
            })
        }

        return this
    }

    private fun sendJsonData(dataHandler: DataHandler, data: Any) {
        MemoryCache.set(url, data)
        dataHandler.onSuccess(data)
    }

    private fun inputStreamToString(inputStream: InputStream): String? {
        val reader = BufferedReader(inputStream.reader())
        var content: String? = null

        try{
            content = reader.readText()
        } catch (e: Exception) {
            e.printStackTrace()
        }finally {
            reader.close()
        }

        return content
    }
}