package com.cursokotlin.pruebaskot.adapters

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.cursokotlin.pruebaskot.models.Person
import com.cursokotlin.pruebaskot.others.inflate
import kotlinx.android.synthetic.main.list_view_person.view.*

class PersonAdapter(val context: Context , val layout: Int ,val list: List<Person>  ) : BaseAdapter(){

    override fun getItem(position: Int): Any {
       return list[position]
    }

    override fun getItemId(position: Int): Long {

        return position.toLong()
    }

    override fun getCount(): Int {
        return list.size
    }
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val view: View
        val vh: PersonViewHolder

        if (convertView == null){
            view = parent.inflate(layout)
            vh = PersonViewHolder(view)
            view.tag = vh

        } else {
            view = convertView
            vh = view.tag as PersonViewHolder

        }

        val fullName = "${list[position].firstName}, ${list[position].lastName}"
        vh.fullName.text = fullName
        vh.age.text =  "${list[position].age}"

        return view

    }

    private class PersonViewHolder (view: View){
        val fullName: TextView = view.textViewName
        val age: TextView = view.textViewAge
    }
}