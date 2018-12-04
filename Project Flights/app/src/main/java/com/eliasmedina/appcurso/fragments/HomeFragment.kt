package com.eliasmedina.appcurso.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.eliasmedina.appcurso.R

class HomeFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
         activity?.setTitle(R.string.home_fragment_tittle)
         return inflater.inflate(R.layout.fragment_home, container, false)
    }
}
