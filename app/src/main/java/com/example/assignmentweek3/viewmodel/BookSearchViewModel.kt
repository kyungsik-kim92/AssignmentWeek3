package com.example.assignmentweek3.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.assignmentweek3.model.BookSearchData
import com.example.assignmentweek3.repository.SearchBookRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class BookSearchViewModel(private val bookSearchRepository: SearchBookRepository) :ViewModel(){


    private val _searchResult = MutableLiveData<BookSearchData>()
    val searchResult: LiveData<BookSearchData> = _searchResult

    fun searchBooks(query: String) = viewModelScope.launch(Dispatchers.IO) {
        val response = bookSearchRepository.searchBooks(query, "accuracy", 1, 15) }
    }

