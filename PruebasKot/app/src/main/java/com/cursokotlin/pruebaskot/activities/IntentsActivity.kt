package com.cursokotlin.pruebaskot.activities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.cursokotlin.pruebaskot.R
import com.cursokotlin.pruebaskot.models.Student
import kotlinx.android.synthetic.main.activity_intents.*

class IntentsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intents)

        button_intent_extras.setOnClickListener { goIntentExtras() }
        button_intent_flags.setOnClickListener { goIntentFlags() }
        button_intent_object.setOnClickListener { goIntentObject() }
    }

    private fun goIntentExtras(){

        val intent = Intent(this, IntentExtrasActivity::class.java)
        intent.putExtra("name","Elias")
        intent.putExtra("lastName","Medina")
        intent.putExtra("age",22)
        intent.putExtra("developer", true)
        startActivity(intent)
    }

    private fun goIntentFlags(){
        val intent = Intent(this, IntentExtrasActivity::class.java)
        //intent.flags = Intent.FLAG_ACTIVITY_NO_HISTORY //No guarda activity en stack
        //intent.flags = Intent.FLAG_ACTIVITY_NO_ANIMATION // No animacion
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
       // finish() //Destruye este activity evitando que entre en el stack
    }
    private fun goIntentObject(){
        val intent = Intent(this, IntentExtrasActivity::class.java)
        val student = Student("Tamara" , "Salafia" , 22 , false)
        intent.putExtra("student", student)
        startActivity(intent)
    }
}
