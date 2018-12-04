package com.eliasmedina.appcurso.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.eliasmedina.appcurso.R
import com.eliasmedina.appcurso.adapters.FlightAdapter
import com.eliasmedina.appcurso.listeners.RecyclerFlightListener
import com.eliasmedina.appcurso.models.Flight
import com.eliasmedina.appcurso.toast
import kotlinx.android.synthetic.main.fragment_departures.view.*

class DeparturesFragment : Fragment() {

    private val list: ArrayList<Flight> by lazy { getFlights() }

    private lateinit var recycler: RecyclerView
    private lateinit var adapter: FlightAdapter
    private val layoutManager by lazy { LinearLayoutManager(context) }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        activity?.setTitle(R.string.departures_fragment_title)
        val rootView = inflater.inflate(R.layout.fragment_departures, container, false)
        recycler = rootView.recyclerView as RecyclerView
        setRecyclerView()

        return rootView
    }

    private fun setRecyclerView() {
        recycler.setHasFixedSize(true)
        recycler.itemAnimator = DefaultItemAnimator()
        recycler.layoutManager = layoutManager
        adapter = (FlightAdapter(list, object: RecyclerFlightListener{
            override fun onClick(flight: Flight, position: Int) {
                activity?.toast("Let's go to ${flight.city}")
            }

            override fun onDelete(flight: Flight, position: Int) {
                list.remove(flight)
                adapter.notifyItemRemoved(position)
                activity?.toast("${flight.city} has been removed!")
            }
        }))

        recycler.adapter = adapter
    }

    private fun getFlights(): ArrayList<Flight> {

        return object: ArrayList<Flight>(){
            init {

                add(Flight(1, "Miami",R.drawable.miami))
                add(Flight(1, "Barcelona",R.drawable.barcelona))
                add(Flight(1, "Japan",R.drawable.japan))
                add(Flight(1, "Las Vegas",R.drawable.las_vegas))
                add(Flight(1, "London",R.drawable.london))
                add(Flight(1, "Rome",R.drawable.rome))

            }
        }
    }
  }
