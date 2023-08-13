package com.example.assignmentweek3.repository

import com.example.assignmentweek3.model.BookSearchData
import com.example.assignmentweek3.util.RetrofitInstance
import retrofit2.Call

class SearchBookRepositoryImpl : SearchBookRepository {
    override fun searchBooks(
        query: String,
        sort: String,
        page: Int,
        size: Int
    ): Call<BookSearchData> {
        return RetrofitInstance.api.searchBooks(query, sort, page, size)
    }
}