package com.example.footballapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    private fun swapFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().replace(R.id.fl_teams_list,fragment).
        addToBackStack("app_stack").commit()
    }
}