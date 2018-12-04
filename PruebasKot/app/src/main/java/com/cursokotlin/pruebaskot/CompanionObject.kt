package com.cursokotlin.pruebaskot

import android.util.Log

class CompanionObject {

    private fun showCase1(){
        //Normal companion object
      val value =  MyClass1.flag
        MyClass1.welcome()
    }

    private fun showCase2 (){
        //Implementando interfaz en companion object
        MyClass2.welcome()
    }
}

class MyClass1{
    companion object {
        val flag = 1

        fun welcome(){
            Log.w("COMPANION OBJECT 1" , "WELCOME FROM COMPANION OBJECT")
        }
    }
}
class MyClass2{

    companion object: Welcome {
        override fun welcome(){
            Log.w("COMPANION OBJECT 1" , "WELCOME FROM COMPANION OBJECT + INTERFACE")
        }
    }
}
interface Welcome {
    fun welcome()
}