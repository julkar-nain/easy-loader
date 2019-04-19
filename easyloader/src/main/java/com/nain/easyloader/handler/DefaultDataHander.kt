package com.nain.easyloader.handler

import android.util.Log
import java.io.InputStream

/**
 * @author julkar nain
 * @since 4/18/19
 */
open class DefaultDataHandler: DataHandler {
    private val TAG = javaClass.simpleName

    override fun onFailure(error: Any) {
       Log.d(TAG, "onFailure()");
    }

    override fun onSuccess(data: Any) {
        Log.d(TAG, "onSuccess()");
    }
}