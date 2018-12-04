package com.cursokotlin.pruebaskot.activities

import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import com.cursokotlin.pruebaskot.R
import com.cursokotlin.pruebaskot.others.LifeCycleEventsActivity

class LifeCycleActivity : LifeCycleEventsActivity() {

    private var exitEnabled = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_life_cycle)
    }

    override fun onBackPressed() {
        if (exitEnabled){
            super.onBackPressed()
        }
        exitEnabled = true
        Toast.makeText(this,"Click back again to exit this screen", Toast.LENGTH_LONG).show()
        Handler().postDelayed(Runnable { exitEnabled = false } , 2000)
    }
}
