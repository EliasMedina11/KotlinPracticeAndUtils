package com.cursokotlin.pruebaskot.app

import android.app.Application
import com.cursokotlin.pruebaskot.others.MySharedPreferences

val preferences: MySharedPreferences? by lazy { Myapp.prefs }

class Myapp : Application(){

    companion object {
        var prefs: MySharedPreferences? = null
    }

    override fun onCreate() {
        super.onCreate()
        prefs = MySharedPreferences(applicationContext)
    }
}