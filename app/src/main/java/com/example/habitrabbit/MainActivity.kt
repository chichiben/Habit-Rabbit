package com.example.habitrabbit

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.view.MenuItem
import android.view.Window
import android.view.WindowManager
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.example.habitrabbit.ui.ProfileFragment
import com.example.habitrabbit.ui.ProgressFragment
import com.example.habitrabbit.ui.habits.HabitsFragment
import com.example.habitrabbit.ui.home.HomeFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

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
        navView.setItemIconSize(128)


        val root = findViewById<LinearLayout>(R.id.linearlayout);
        var count = 0;
        var habitButtons: ArrayList<RelativeLayout> = arrayListOf()
        for (i in 0 until root.childCount){
            val view = root.getChildAt(i);
            if (view is RelativeLayout){
                val habitID = view.context.resources.getResourceEntryName(view.id)
                val idNum = habitID.substring(5, habitID.length).toInt()
                // Setting listener for button press.
                val resID = resources.getIdentifier(habitID, "id", packageName)
                habitButtons.add(findViewById<RelativeLayout>(resID));
                habitButtons[idNum-1].setOnClickListener{
                    var messageID = resources.getIdentifier("habit" + idNum + "Text", "id", packageName)
                    var message = findViewById<TextView>(messageID).text
                    var percentID = resources.getIdentifier("habit" + idNum + "Percentage", "id", packageName)
                    var percent = findViewById<TextView>(percentID).text
                    println("habit" + idNum + "Text")
                    println(message)
                    println(percent)
                    var habitSelectIntent = Intent(this, HabitSelect::class.java).apply {
                        putExtra("Title", message.toString())
                        putExtra("Percent", percent.toString())
                        putExtra("ID", idNum)
                    }
                    println((habitSelectIntent))
                    startActivity(habitSelectIntent)
                    //setContentView(R.layout.fragment_habit)
                }
            }
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
                    val profileFragment = ProfileFragment.newInstance()
                    openFragment(profileFragment)
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
        val activeFragment = supportFragmentManager.findFragmentById(R.id.container)

        val transaction = supportFragmentManager.beginTransaction()
        if (activeFragment == null) {
            transaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right);
        } else {
            if (activeFragment!!::class != fragment::class) {
                transaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right);
            }
        }


        transaction.replace(R.id.container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}
