package com.example.assignmentweek3.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.assignmentweek3.api.BookApiService
import com.example.assignmentweek3.model.BookSearchData
import com.example.assignmentweek3.model.Document
import com.example.assignmentweek3.repository.SearchBookRepository
import com.example.assignmentweek3.util.RetrofitInstance
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BookSearchViewModel(private val searchBookRepository: SearchBookRepository) :ViewModel(){


    val api : BookApiService = RetrofitInstance.api


    private val _searchResultLiveData = MutableLiveData<List<Document>>()
    val searchResultLiveData: LiveData<List<Document>> = _searchResultLiveData




    fun searchBooks(query: String)  {
        if (query.isNotEmpty()) {
            searchBookRepository.searchBooks(
                query,
                DEFAULT_SEARCH_SORT,
                DEFAULT_SEARCH_PAGE,
                DEFAULT_SEARCH_SIZE
            ).enqueue(
                object : Callback<BookSearchData> {
                    override fun onResponse(
                        call: Call<BookSearchData>,
                        response: Response<BookSearchData>
                    ) {

                        val searchData = response.body()

                        searchData?.let {
                            _searchResultLiveData.value = it.documents
                        }

                    }

                    override fun onFailure(call: Call<BookSearchData>, t: Throwable) {

                    }

                }
            )

        }

    }

    companion object {

        private const val DEFAULT_SEARCH_SORT = "accuracy"
        private const val DEFAULT_SEARCH_PAGE = 1
        private const val DEFAULT_SEARCH_SIZE = 30
    }


}

