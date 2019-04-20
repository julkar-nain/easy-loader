package com.nain.easyloader.util

import android.app.Activity
import android.content.Context
import android.util.DisplayMetrics

object Utils{
    fun getDeviceMetrices(activity: Activity):DisplayMetrics{
        val displaymetrics = DisplayMetrics()
        activity.windowManager.defaultDisplay.getMetrics(displaymetrics)

        return displaymetrics
    }
}