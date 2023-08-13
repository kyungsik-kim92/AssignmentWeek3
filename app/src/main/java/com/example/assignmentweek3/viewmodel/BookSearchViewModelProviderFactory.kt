package com.example.assignmentweek3.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.assignmentweek3.repository.SearchBookRepository

class BookSearchViewModelProviderFactory(private val searchBookRepository: SearchBookRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(BookSearchViewModel::class.java)) {
            return BookSearchViewModel(searchBookRepository) as T
        }
        throw IllegalArgumentException("ViewModel class not found")
    }
}