package com.cursokotlin.pruebaskot.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.cursokotlin.pruebaskot.R
import com.cursokotlin.pruebaskot.adapters.PersonAdapter
import com.cursokotlin.pruebaskot.models.Person
import kotlinx.android.synthetic.main.activity_list_view.*

class ListViewActivity : AppCompatActivity() {

    private lateinit var adapter: PersonAdapter
    private lateinit var personList: List<Person>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)

        personList = getPersons()
        adapter = PersonAdapter(this , R.layout.list_view_person , getPersons())
        listView.adapter = adapter

    }

    private fun getPersons (): List<Person> {
        return listOf(
                Person("Elias" , "Medina" , 22),
                Person("Elias" , "Medina" , 22),
                Person("Elias" , "Medina" , 22),
                Person("Elias" , "Medina" , 22),
                Person("Elias" , "Medina" , 22),
                Person("Elias" , "Medina" , 22),
                Person("Elias" , "Medina" , 22),
                Person("Elias" , "Medina" , 22),
                Person("Elias" , "Medina" , 22),
                Person("Elias" , "Medina" , 22),
                Person("Elias" , "Medina" , 22),
                Person("Elias" , "Medina" , 22),
                Person("Elias" , "Medina" , 22)
                )
    }
}
