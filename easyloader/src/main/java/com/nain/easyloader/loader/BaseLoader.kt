package com.nain.easyloader.loader

import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

/**
 * @author julkar nain
 * @since 4/18/19
 */
open class BaseLoader {

    internal lateinit var url: String
    private val executorService: ExecutorService = Executors.newFixedThreadPool(10)

    internal fun download(dataHandler: DataHandler) {
        executorService.submit(Loader(url, dataHandler))
    }

    class Loader(val url: String, val dataHandler: DataHandler) : Runnable {
        private val CNNECTION_TIME_OUT = 30000
        private val READ_TIME_OUT = 30000

        override fun run() {
            val formattedUrl = URL(url)
            val connection: HttpURLConnection = formattedUrl.openConnection() as HttpURLConnection
            connection.setConnectTimeout(CNNECTION_TIME_OUT)
            connection.setReadTimeout(READ_TIME_OUT)
            connection.setInstanceFollowRedirects(true)
            val data: InputStream? = connection.getInputStream()

            data?.let {
                dataHandler.onSuccess(it)
            } ?: run {
                dataHandler.onFailure("opps something wrong")
            }
        }
    }
}
