package com.example.habitrabbit
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class HabitSelect : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_habit)

        var intent1 = intent;
        println((intent))
        var title = intent1?.getStringExtra("Title");
        var percent = intent1?.getStringExtra("Percent").toString()
        val textView1 = findViewById<TextView>(R.id.title)
        textView1.text = title
        val textView2 = findViewById<TextView>(R.id.percent)
        textView2.text = percent
        val textView3 = findViewById<TextView>(R.id.desc)
        if (intent1?.extras?.getInt("ID") != 1) {
            textView3.text = ""
        }



        println(("Title $title"))
        println(("Percent $percent"))

        val checkInButton = findViewById<Button>(R.id.checkin)
        checkInButton.setOnClickListener{
            val percentage = findViewById<TextView>(R.id.percent).text
            val num = percentage.substring(0, percentage.length-1)
            println((num))

        }

        val exitButton = findViewById<ImageView>(R.id.closeHabitButton)
        exitButton.setOnClickListener {
            println(("exit habit button is clicked!"));
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }
}