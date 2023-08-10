package com.example.assignmentweek3.repository

import com.example.assignmentweek3.model.BookSearchData
import retrofit2.Call

interface SearchBookRepository {

    suspend fun searchBooks(
        query: String,
        sort: String,
        page: Int,
        size: Int,
    ): Call<BookSearchData>
}