package com.example.habitrabbit

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Switch
import androidx.appcompat.app.AppCompatActivity
import com.example.habitrabbit.R.layout.fragment_habit
import com.example.habitrabbit.R.layout.habit_creation
import com.google.android.material.textfield.TextInputEditText

class HabitCreation : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(habit_creation)

        var freq_measure: String? = "days"
        val swl: Switch = findViewById(R.id.switch1)


        val exitButton = findViewById<ImageButton>(R.id.exit)
            exitButton.setOnClickListener {
                println(("exit habit button is clicked!"));
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }

        val Createbutton = findViewById<Button>(R.id.create)
        Createbutton.setOnClickListener {
            println(("create button is clicked!"))
//            Habit hab = new Habit(
//                "@string/habit_name",
//                "a",
//                "b",
//                5,
//                true
//            );
            var edit1: TextInputEditText  = findViewById(R.id.number_checkin)
            var edit2: TextInputEditText  = findViewById(R.id.name_habit)
            var edit3: TextInputEditText  = findViewById(R.id.user)

            val hab = object {
                var name: String? = edit2.text.toString()
                var freq_measurement: String? = freq_measure
                var shared_username: String? = edit3.text.toString()
                var freq_num: Int = Integer.parseInt(edit1.text.toString()) // or use checkin_number
                var shared_habit = swl.isChecked
            }
            println(hab.name + " " + hab.freq_measurement + " " + hab.shared_username + " " + hab.freq_num + " " + hab.shared_habit)
            println("above contains the " + hab.name + " object!")
            // submit this to DS within class that holds habits, so that other pages can dynamically update
        }

        val daysButton = findViewById<Button>(R.id.days)
        daysButton.setOnClickListener {
            freq_measure = "days"
        }

        val weeksButton = findViewById<Button>(R.id.weeks)
        weeksButton.setOnClickListener {
            freq_measure = "weeks"
        }

        val monthsButton = findViewById<Button>(R.id.months)
        monthsButton.setOnClickListener {
            freq_measure = "months"
        }
    }

}
