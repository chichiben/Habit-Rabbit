package com.example.habitrabbit.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import com.example.habitrabbit.R

class CarrotsHarvested : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_carrots_harvested)

        val exitCarrotsHarvested = findViewById<ImageView>(R.id.exitCarrotsHarvested)
        exitCarrotsHarvested.setOnClickListener {
            onBackPressed()
        }
    }
}
