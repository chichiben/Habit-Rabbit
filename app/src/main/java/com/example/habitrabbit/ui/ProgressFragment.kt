package com.example.habitrabbit.ui

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController

import com.example.habitrabbit.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class ProgressFragment : Fragment() {

    companion object {
        fun newInstance() = ProgressFragment()
    }

    private lateinit var viewModel: ProgressViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //val navView: BottomNavigationView = inflater.inflate(R.layout.fragment_progress, container, false).findViewById<BottomNavigationView>(R.id.nav_view)
        return inflater.inflate(R.layout.fragment_progress, container, false)
    }

    /*
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ProgressViewModel::class.java)
        // TODO: Use the ViewModel

        //val navBar = findNavController()
    }
    */


}
