package com.example.worldlibrary

import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.worldlibrary.Views.*
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        setContentView(R.layout.activity_main)
        nav_view.setOnNavigationItemSelectedListener(navigationItemSelectedListener)
        defView()
    }

    private fun defView() {
        val homeFragment = HomeFragment()
        supportFragmentManager.beginTransaction().add(R.id.nav_host_container, homeFragment, "home")
            .addToBackStack("hello").commit()
    }

    private val navigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            var selectedFragment: Fragment? = null
            when (item.itemId) {
                R.id.navigation_home-> selectedFragment = HomeFragment()
                R.id.navigation_location -> selectedFragment = LocationFragment()
                R.id.navigation_publish-> selectedFragment = PublishFragment()
                R.id.navigation_inbox-> selectedFragment = ChatFragment()
                R.id.navigation_activity -> selectedFragment = ActivityFragment()
            }
            supportFragmentManager.beginTransaction().replace(
                R.id.nav_host_container,
                selectedFragment!!
            ).addToBackStack("hello").commit()
            true
        }


}
