package com.example.assignmentweek3

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.assignmentweek3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

            setFragment()
      }

    private fun setFragment() {
        val searchFragment = supportFragmentManager.beginTransaction()
        searchFragment.replace(R.id.fragmentContainerView,SearchFragment()).commit()
    }
}