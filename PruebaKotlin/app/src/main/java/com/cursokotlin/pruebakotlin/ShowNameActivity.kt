package com.cursokotlin.pruebakotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_show_name.*

class ShowNameActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_name)
        getAndShowName()
        btnBack.setOnClickListener { onBackPressed() }
    }

        private fun getAndShowName() {
        val bundle = intent.extras
        val name = bundle.get("name")
        tvGreeting.text =getString(R.string.welcome , name)
    }
}
