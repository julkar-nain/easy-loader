package com.nain.easyloader.loader

import java.io.InputStream
import java.lang.Exception

/**
 * @author julkar nain
 * @since 4/18/19
 */
interface DataHandler{
    fun onSuccess(data: InputStream)
    fun onFailure(error: Any)
}