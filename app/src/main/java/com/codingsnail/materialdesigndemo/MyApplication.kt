package com.codingsnail.materialdesigndemo

import android.app.Application

/**
 * Created by Snail on 3/1/2018 3:42 PM
 * Contact with slowsnail0223@gmail.com
 */
class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        globalApplication = this
    }

    companion object {
        lateinit var globalApplication: MyApplication
    }
}