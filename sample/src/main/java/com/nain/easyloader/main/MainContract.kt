package com.nain.easyloader.main

import com.nain.easyloader.common.BasePresenter
import com.nain.easyloader.common.BaseView
import com.nain.easyloader.model.User

/**
 * @author julkar nain
 * @since 4/21/19
 */
interface MainContract {
    interface View : BaseView<Presenter> {
        fun showList(userList : List<User>)
    }

    interface Presenter : BasePresenter {
        fun loadUserData()
    }
}