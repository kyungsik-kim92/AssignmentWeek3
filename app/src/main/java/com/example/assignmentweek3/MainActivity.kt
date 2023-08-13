package com.example.assignmentweek3

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.assignmentweek3.databinding.ActivityMainBinding
import com.example.assignmentweek3.repository.SearchBookRepositoryImpl
import com.example.assignmentweek3.viewmodel.BookSearchViewModel
import com.example.assignmentweek3.viewmodel.BookSearchViewModelProviderFactory

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding
    lateinit var bookSearchViewModel: BookSearchViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setFragment()

        val searchBookRepository = SearchBookRepositoryImpl()

        val factory = BookSearchViewModelProviderFactory(searchBookRepository)
        bookSearchViewModel = ViewModelProvider(this, factory)[BookSearchViewModel::class.java]



    }

    private fun setFragment() {
        val searchFragment = supportFragmentManager.beginTransaction()
        searchFragment.replace(R.id.frame_layout, SearchFragment()).commit()
    }
}