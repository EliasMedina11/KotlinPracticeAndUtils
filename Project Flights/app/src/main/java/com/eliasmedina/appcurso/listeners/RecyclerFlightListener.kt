package com.eliasmedina.appcurso.listeners

import com.eliasmedina.appcurso.models.Flight

interface RecyclerFlightListener{

    fun onClick (flight: Flight, position: Int)
    fun onDelete (flight: Flight, position: Int)
}