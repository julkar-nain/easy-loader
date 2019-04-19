package com.nain.easyloader.handler

import java.io.InputStream
import java.lang.Exception

/**
 * @author julkar nain
 * @since 4/18/19
 */
interface DataHandler{
    fun onSuccess(data: Any)
    fun onFailure(error: Any)
}