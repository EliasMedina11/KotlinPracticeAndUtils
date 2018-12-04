package com.cursokotlin.pruebaskot.models

import android.support.v7.widget.Toolbar

interface IToolbar {

     fun toolbarToLoad (toolbar: Toolbar?)
    fun enableHomeDisplay(value: Boolean)
}