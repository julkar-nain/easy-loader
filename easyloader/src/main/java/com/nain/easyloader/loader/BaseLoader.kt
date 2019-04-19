package com.nain.easyloader.loader

import com.nain.easyloader.handler.DataHandler
import com.nain.easyloader.task.CancellableTask
import com.nain.easyloader.task.TaskManager
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL
import java.util.concurrent.Future

/**
 * @author julkar nain
 * @since 4/18/19
 */
open class BaseLoader : CancellableTask {

    internal lateinit var url: String
    private lateinit var task : Future<*>

    internal fun download(dataHandler: DataHandler) {
        task = TaskManager.addTask(RunnableTask(url, dataHandler))
    }

    override fun cancelTask(){
        TaskManager.cancelTask(task)
    }

    class RunnableTask(val url: String, val dataHandler: DataHandler) : Runnable {
        private val CNNECTION_TIME_OUT = 30000
        private val READ_TIME_OUT = 30000

        override fun run() {
            try {
                val formattedUrl = URL(url)
                val connection: HttpURLConnection = formattedUrl.openConnection() as HttpURLConnection
                connection.setConnectTimeout(CNNECTION_TIME_OUT)
                connection.setReadTimeout(READ_TIME_OUT)
                connection.setInstanceFollowRedirects(true)
                val data: InputStream? = connection.getInputStream()

                if (data != null){
                    dataHandler.onSuccess(data)
                }else{
                    dataHandler.onFailure("opps something wrong")
                }

            }catch (e: Exception){
                dataHandler.onFailure(e)
            }
        }
    }
}
