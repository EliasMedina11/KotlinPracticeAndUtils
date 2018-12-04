package com.cursokotlin.pruebaskot.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.cursokotlin.pruebaskot.R
import kotlinx.android.synthetic.main.activity_click_events.*

class ClickEventsActivity : AppCompatActivity(), View.OnLongClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_click_events)
        clickInLine()

        val btn1 = findViewById<Button>(R.id.buttonClickMulti1)
        val btn2: Button  = buttonClickMulti2
        val btn3 = buttonClickMulti3

        btn1.setOnLongClickListener(this)
        btn2.setOnLongClickListener(this)
        btn3.setOnLongClickListener(this)
    }

    fun xmlClick(view : View){
        Toast.makeText(this , "Click by XML!" , Toast.LENGTH_SHORT).show()
    }

    private fun clickInLine(){
        var btn = findViewById<Button>(R.id.buttonClickInLine)
        btn.setOnClickListener{ Toast.makeText(this,"Click in Line!" , Toast.LENGTH_SHORT).show()}
    }

    override fun onLongClick(view: View): Boolean {
        when (view.id) {
            R.id.buttonClickMulti1 -> Toast.makeText(this, "Click Multi 1!", Toast.LENGTH_SHORT).show()
            R.id.buttonClickMulti2 -> Toast.makeText(this, "Click Multi 2!", Toast.LENGTH_SHORT).show()
            R.id.buttonClickMulti3 -> Toast.makeText(this, "Click Multi 3!", Toast.LENGTH_SHORT).show()
        }
        return true
    }



}
