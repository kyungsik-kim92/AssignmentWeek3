package com.example.assignmentweek3

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.assignmentweek3.databinding.ActivityMainBinding
import com.example.assignmentweek3.viewmodel.BookSearchViewModel

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding
    lateinit var bookSearchViewModel: BookSearchViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

            setFragment()


        binding.btnSearch.setOnClickListener {
            bookSearchViewModel.searchBook(binding.etSearch.text.toString())
        }


      }

    private fun setFragment() {
        val searchFragment = supportFragmentManager.beginTransaction()
        searchFragment.replace(R.id.frame,SearchFragment()).commit()
    }
}