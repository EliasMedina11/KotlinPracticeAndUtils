package com.cursokotlin.pruebaskot.activities

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.Toolbar
import com.cursokotlin.pruebaskot.R
import com.cursokotlin.pruebaskot.models.Student
import com.cursokotlin.pruebaskot.others.ToolbarActivity
import kotlinx.android.synthetic.main.activity_intent_extras.*


class IntentExtrasActivity : ToolbarActivity() {

       override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent_extras)

        toolbarToLoad(toolbar as Toolbar)
        enableHomeDisplay(true)

        getIntentExtras()
        button_back.setOnClickListener{startActivity(Intent(this,IntentsActivity::class.java))}
        getStudent()

    }

    private fun getIntentExtras (){
        val name = intent.getStringExtra("name")
        val lastName = intent.getStringExtra("lastName")
        val age: Int = intent.getIntExtra("age",-1)
        val developer = intent.getBooleanExtra("developer",false)

        textViewName.text = name
        textViewLastName.text = lastName
        textViewAge.text = "$age"
        checkBoxDeveloper.isChecked = developer
        checkBoxDeveloper.text = getString(R.string.developer)
    }

    private fun getStudent(){

        val student = intent.getParcelableExtra<Student>("student")
        student?.let {
            textViewName.text = student.name
            textViewLastName.text = student.lastName
            textViewAge.text = "${student.age}"
            checkBoxDeveloper.isChecked = student.isDeveloper
            checkBoxDeveloper.text = getString(R.string.developer)
        }
    }
}
