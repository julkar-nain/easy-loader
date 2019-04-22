package com.nain.easyloader.main

import com.nain.easyloader.EasyLoader
import com.nain.easyloader.SAMPLE_JSON_1
import com.nain.easyloader.Utils.mapUserObject
import com.nain.easyloader.handler.DefaultDataHandler
import com.nain.easyloader.model.User
import org.json.JSONArray

/**
 * @author julkar nain
 * @since 4/21/19
 */
open class MainPresenter(val view: MainContract.View) : MainContract.Presenter{
    override fun loadUserData() {
        EasyLoader.jsonBuilder().src(SAMPLE_JSON_1).build().loadJSON(object : DefaultDataHandler(){
            override fun onSuccess(data: Any) {
                super.onSuccess(data)
                view.showList(mapUserObject(data as JSONArray))
            }
        })
    }

    override fun start() {
        loadUserData()
    }
}