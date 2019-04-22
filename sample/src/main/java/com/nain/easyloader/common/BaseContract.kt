package com.nain.easyloader.common

/**
 * @author julkar nain
 * @since 4/21/19
 */

interface BaseView<T> {
    fun setPresenter(presenter: T)
}

interface BasePresenter {
    fun start()
}
