package com.example.habitrabbit.ui

import android.content.Intent
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.navigation.fragment.findNavController

import com.example.habitrabbit.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class ProgressFragment : Fragment() {

    companion object {
        fun newInstance() = ProgressFragment()
    }

    private lateinit var viewModel: ProgressViewModel
    private lateinit var carrotImg: ImageView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //val navView: BottomNavigationView = inflater.inflate(R.layout.fragment_progress, container, false).findViewById<BottomNavigationView>(R.id.nav_view)
        val root = inflater.inflate(R.layout.fragment_progress, container, false)

        carrotImg = root.findViewById(R.id.carrotsHarvested) as ImageView
        carrotImg.setOnClickListener {
            val intent = Intent(this@ProgressFragment.context, CarrotsHarvested::class.java)
            startActivity(intent)
        }

        return root
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
