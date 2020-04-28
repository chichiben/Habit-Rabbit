package com.example.habitrabbit.ui.habits
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.*
import com.example.habitrabbit.R

class HabitsFragment : Fragment() {
    private lateinit var habitsViewModel: HabitsViewModel
//    private var title = ""
//    private var percent = ""
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        habitsViewModel =
            ViewModelProviders.of(this).get(HabitsViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_habit, container, false)

//        val intent = activity?.intent;
//        // Get the Intent that started this activity and extract the string
//        title = intent?.getStringExtra("Title").toString();
//        percent = intent?.getStringExtra("Percent").toString()
//        val textView1 = root.findViewById<TextView>(R.id.title)
//        textView1.text = title
//
//        val textView2 = root.findViewById<TextView>(R.id.percent)
//        textView2.text = percent

        // Capture the layout's TextView and set the string as its text
        val textView: TextView = root.findViewById(R.id.text_home)
        habitsViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })

//        println((title));
//        println((percent));

        // Trying to get the "X" button to return to the home screen. not working atm

        val currentView = inflater.inflate(R.layout.fragment_habit, container, false)
        val closeHabitButton = currentView.findViewById<RelativeLayout>(R.id.closeHabitButton)
        closeHabitButton.setOnClickListener{
            activity?.onBackPressed()
            println("test")
        }

        // Setting listener for check in button
//        val checkinButton = resources.getIdentifier("checkin", "id", "com.example.habitrabbit.ui.habits") as Button
//        checkinButton.setOnClickListener{
//            //TO DO
//            // get the percentage, convert to fraction, increment by 1/x and then convert back to percent
//            // update percentage in xml and refresh, can only click once when loaded
//        }


        return root
    }

}