package com.cursokotlin.pruebaskot.others

import android.content.Context

class MySharedPreferences (context: Context) {

    // Nombre fichero Shared Preferences
    private val fileName = "mis_preferencias"

    // Instancia de ese Fichero
    private val prefs = context.getSharedPreferences(fileName , Context.MODE_PRIVATE)

    //por cada una de las variable que vamos a guardar en nuestro fichero shared preferences
    var name : String
        get() = prefs.getString("name" , "")
        set(value) = prefs.edit().putString("name" , value).apply()

    var age : Int
        get() = prefs.getInt("age" , -1)
        set(value) = prefs.edit().putInt("age" , value).apply()
}