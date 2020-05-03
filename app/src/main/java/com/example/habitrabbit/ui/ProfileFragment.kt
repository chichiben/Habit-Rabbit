package com.example.habitrabbit.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.ViewPager
import com.example.habitrabbit.R
import com.google.android.material.tabs.TabLayout

class ProfileFragment : Fragment() {
    private lateinit var demoCollectionPagerAdapter: DemoCollectionPagerAdapter
    private lateinit var viewPager: ViewPager


    companion object {
        fun newInstance() = ProfileFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // ViewPager set up with tabs.
        view?.findViewById<TabLayout>(R.id.viewTabLayout)?.setupWithViewPager(viewPager)

        val root = inflater.inflate(R.layout.fragment_profile, container, false)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        demoCollectionPagerAdapter = DemoCollectionPagerAdapter(childFragmentManager)
        viewPager = view.findViewById(R.id.pager)
        viewPager.adapter = demoCollectionPagerAdapter
    }
}

class DemoCollectionPagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {

    override fun getCount(): Int  = 2

    override fun getItem(i: Int): Fragment {
        val fragment = DemoObjectFragment(i)
        fragment.arguments = Bundle().apply {
            // Our object is just an integer :-P
            putInt(ARG_OBJECT, i + 1)
        }
        return fragment
    }

    override fun getPageTitle(position: Int): CharSequence {
        if (position == 0) {
            return "DETAILS"
        } else {
            return "HISTORY"
        }
    }
}

private const val ARG_OBJECT = "object"

// Instances of this class are fragments representing a single
// object in our collection.
class DemoObjectFragment(private val position: Int) : Fragment() {

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return if (position == 0) {
            println("Profile Details Page")
            inflater.inflate(R.layout.fragment_profile_details, container, false)

        } else {
            println("Profile History Page")
            inflater.inflate(R.layout.fragment_profile_history, container, false)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        /*
        arguments?.takeIf { it.containsKey(ARG_OBJECT) }?.apply {
            val textView: TextView = view.findViewById(R.id.title2)
            textView.text = getInt(ARG_OBJECT).toString()
        }
        */

    }
}