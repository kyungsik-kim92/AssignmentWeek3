package com.example.assignmentweek3.repository

import com.example.assignmentweek3.model.BookSearchData
import retrofit2.Call
import retrofit2.Response

interface SearchBookRepository {

   suspend fun searchBooks(
        query: String,
        sort: String,
        page: Int,
        size: Int,
    ): Response<BookSearchData>
}