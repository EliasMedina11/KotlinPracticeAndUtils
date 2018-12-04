package com.cursokotlin.pruebaskot.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.cursokotlin.pruebaskot.R
import kotlinx.android.synthetic.main.activity_extension_functions.*


class ExtensionFunctionsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_extension_functions)

        val btn = findViewById<Button>(R.id.buttonById)
        btn.setOnClickListener { Toast.makeText(this,"Click By ID!",Toast.LENGTH_SHORT).show() }

        buttonbyKAT.setOnClickListener { Toast.makeText(this,"Click By KAT!",Toast.LENGTH_SHORT).show() }
    }
}
