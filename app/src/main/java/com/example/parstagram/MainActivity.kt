package com.example.parstagram

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.parstagram.fragments.ComposeFragment
import com.example.parstagram.fragments.FeedFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.parse.*

//let user create a post by taking a photo with their camera

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentManager: FragmentManager = supportFragmentManager

        findViewById<BottomNavigationView>(R.id.bottom_navigation).setOnItemSelectedListener {
            item ->

            var fragmentToShow: Fragment? = null
            when (item.itemId) {

                R.id.action_home -> {
                    fragmentToShow = FeedFragment()
                }

                R.id.action_compose -> {
                    fragmentToShow = ComposeFragment()
                }

                R.id.action_profile -> {
                    //fragmentToShow = ProfileFragment()
                }

            }
            if (fragmentToShow != null) {
                fragmentManager.beginTransaction().replace(R.id.flContainer, fragmentToShow).commit()

            }

            true
        }

        // Set default selection
        findViewById<BottomNavigationView>(R.id.bottom_navigation).selectedItemId = R.id.action_home

    }
    companion object {
        const val TAG = "MainActivity"
    }
}