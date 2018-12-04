package com.cursokotlin.pruebaskot.others

import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import com.cursokotlin.pruebaskot.models.IToolbar

open class ToolbarActivity : AppCompatActivity(), IToolbar {

    protected var _toolbar: Toolbar? = null

    override fun enableHomeDisplay(value: Boolean) {
        supportActionBar?.setDisplayHomeAsUpEnabled(value)
    }

    override fun toolbarToLoad(toolbar: Toolbar?) {
        _toolbar = toolbar
        _toolbar?.let { setSupportActionBar(_toolbar) }
    }


}
