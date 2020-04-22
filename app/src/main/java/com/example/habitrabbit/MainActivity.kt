package com.example.habitrabbit

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.MenuItem
import android.view.Window
import android.view.WindowManager
import android.widget.RelativeLayout
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController

class MainActivity : AppCompatActivity() {
    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)
        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications
            )
        )
        navView.setupWithNavController(navController)

        // Setting listener for button press on the first habit.
        val habitButton = findViewById<RelativeLayout>(R.id.habit1)
        habitButton.setOnClickListener{
            setContentView(R.layout.fragment_habit)
        }

        // Setting listeners for the bottom nav panel.
        navView.setOnNavigationItemSelectedListener { item: MenuItem ->
            return@setOnNavigationItemSelectedListener when (item.itemId) {
                R.id.navigation_createTask -> {
                    println(("Create Task"));
                    super.onBackPressed();
                    true
                }
                R.id.navigation_progress -> {
                    println(("Progress"));
                    setContentView(R.layout.fragment_progress)
                    true
                }
                R.id.navigation_profile -> {
                    println(("Profile"));
                    // setContentView(VIEW HERE)
                    true
                }
                else -> false
            }
        }
    }
}
