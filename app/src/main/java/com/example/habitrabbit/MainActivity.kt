package com.example.habitrabbit

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.Window
import android.view.WindowManager
import android.widget.ImageButton
import android.widget.RelativeLayout
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.habitrabbit.ui.ProgressFragment
import com.example.habitrabbit.ui.home.HomeFragment

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
            val habitSelectIntent = Intent(this, HabitSelect::class.java)
            startActivity(habitSelectIntent)
            //setContentView(R.layout.fragment_habit)
        }

        // Setting listeners for the bottom nav panel.
        navView.setOnNavigationItemSelectedListener { item: MenuItem ->
            return@setOnNavigationItemSelectedListener when (item.itemId) {
                R.id.navigation_createTask -> {
                    println(("Habits"));
                    val homeFragment = HomeFragment.newInstance()
                    openFragment(homeFragment)
                    true
                }
                R.id.navigation_progress -> {
                    println("Progress")
                    val progressFragment = ProgressFragment.newInstance()
                    openFragment(progressFragment)


                    true
                }
                R.id.navigation_profile -> {
                    println(("Profile"));
                    // TODO
                    true
                }
                else -> false
            }
        }

        val button = findViewById<ImageButton>(R.id.add_habit)
            button.setOnClickListener {
                println(("add habit button is clicked!"));
                val intent = Intent(this, HabitCreation::class.java)
                startActivity(intent)
            }
    }

    private fun openFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}
