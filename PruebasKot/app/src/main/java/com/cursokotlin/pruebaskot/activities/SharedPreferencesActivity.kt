package com.cursokotlin.pruebaskot.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.cursokotlin.pruebaskot.R
import com.cursokotlin.pruebaskot.app.preferences
import kotlinx.android.synthetic.main.activity_shared_preferences.*

class SharedPreferencesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared_preferences)


        buttonSave.setOnClickListener { setValuesSharedPreferences(); cleanEditTexts(); getValuesSharedPreferences(); }
        getValuesSharedPreferences()
    }

    private fun getValuesSharedPreferences (){
        if (preferences!!.name.isNotEmpty() && preferences!!.age >= 0){
            textViewSharedPreferences.text = "Welcome ${preferences!!.name} , your age is ${preferences!!.age}"
        } else {
            textViewSharedPreferences.text = "Welcome. Please save your name and your age"
        }
    }

    private fun setValuesSharedPreferences (){
        if (editTextName.text.toString().isNotEmpty() && editTextAge.text.toString().isNotEmpty()){
            preferences!!.name = editTextName.text.toString()
            preferences!!.age = editTextAge.text.toString().toInt()
            Toast.makeText(this , "Values have been saved succesfully!", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this , "Values have been saved succesfully!", Toast.LENGTH_SHORT).show()

        }
    }

    private fun cleanEditTexts (){

        editTextName.text.clear()
        editTextAge.text.clear()

    }
}
