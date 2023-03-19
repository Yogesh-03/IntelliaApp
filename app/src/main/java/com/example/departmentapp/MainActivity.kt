package com.example.departmentapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var mainActivityFragContainer:FrameLayout
    private lateinit var bottomNav:BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainActivityFragContainer = findViewById(R.id.mainActivityFragContainer)
        bottomNav = findViewById(R.id.bottomNavigationView)

        replaceFragment(HomeFragment())
        bottomNav.selectedItemId = R.id.bottomNavHome

        bottomNav.setOnItemSelectedListener {
            when(it.itemId){
                R.id.bottomNavHome ->{
                    replaceFragment(HomeFragment())
                }
                R.id.bottomNavTeam ->{
                    replaceFragment(TeamFragment())
                }
                R.id.bottomNavEventsOrganized -> {
                    replaceFragment(EventsFragment())
                }
                R.id.bottomNavContactUs ->{
                    replaceFragment(ContactFragment())
                }
                else ->{

                }
            }
            true
        }
    }

    private fun replaceFragment(fragment: Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.mainActivityFragContainer, fragment)
        fragmentTransaction.commit()
    }
}