package com.cursokotlin.persistenciaconkotlin

import android.app.Application

/**
 * Created by emedina on 11/4/18.
 */
class SharedApp : Application() {
    companion object {
        lateinit var prefs: Prefs
    }

    override fun onCreate() {
        super.onCreate()
        prefs = Prefs(applicationContext)
    }
}