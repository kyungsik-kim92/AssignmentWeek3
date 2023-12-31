package com.example.assignmentweek3.repository

import com.example.assignmentweek3.model.BookSearchData
import com.example.assignmentweek3.util.RetrofitInstance
import retrofit2.Call
import retrofit2.Response

class SearchBookRepositoryImpl : SearchBookRepository {
    override suspend fun searchBooks(
        query: String,
        sort: String,
        page: Int,
        size: Int
    ): Response<BookSearchData> {
        return RetrofitInstance.api.searchBooks(query, sort, page, size)
    }
}