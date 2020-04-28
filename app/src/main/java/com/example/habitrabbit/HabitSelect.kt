package com.example.habitrabbit

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.Switch
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText

class HabitSelect : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_habit)

        val exitButton = findViewById<ImageView>(R.id.closeHabitButton)
        exitButton.setOnClickListener {
            println(("exit habit button is clicked!"));
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }
}