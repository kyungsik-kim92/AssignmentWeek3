package com.example.assignmentweek3.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.assignmentweek3.model.BookSearchData
import com.example.assignmentweek3.model.Document
import com.example.assignmentweek3.repository.SearchBookRepository
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BookSearchViewModel(private val searchBookRepository: SearchBookRepository) :ViewModel(){


    private val _searchResultLiveData = MutableLiveData<List<Document>>()
    val searchResultLiveData: LiveData<List<Document>> = _searchResultLiveData



    fun searchBooks(query: String) = viewModelScope.launch{

        val response = searchBookRepository.searchBooks(query, DEFAULT_SEARCH_SORT, DEFAULT_SEARCH_PAGE, DEFAULT_SEARCH_SIZE)
        if (response.isSuccessful) {
            response.body()?.let { body ->
                _searchResultLiveData.value = body.documents
            }
        }

    }






    companion object {

        private const val DEFAULT_SEARCH_SORT = "accuracy"
        private const val DEFAULT_SEARCH_PAGE = 1
        private const val DEFAULT_SEARCH_SIZE = 30
    }


}

