package com.nain.easyloader.main

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.nain.easyloader.EasyLoader
import com.nain.easyloader.R
import com.nain.easyloader.model.User
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), MainContract.View {

    private val TAG = javaClass.simpleName

    private lateinit var presenter: MainContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate()")
        setContentView(R.layout.activity_main)

        setPresenter(MainPresenter(this))
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume()")

        presenter.start()
    }

    override fun showList(userList: List<User>) {
        val list = mutableListOf<String>()

        for (item in userList) {
            list.add(item.profileImage.large)
        }
        EasyLoader
            .imageBuilder()
            .cacheLimit(10)
            .asList()
            .src(list)
            .container(recyclerview)
            .build()
            .show()
    }

    override fun setPresenter(presenter: MainContract.Presenter) {
        this.presenter = presenter
    }

    override fun onDestroy() {
        super.onDestroy()
        EasyLoader.clearCache()
        EasyLoader.cancelAllTasks()
    }
}