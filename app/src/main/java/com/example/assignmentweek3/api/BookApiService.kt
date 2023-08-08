package com.example.assignmentweek3.api

import com.example.assignmentweek3.constants.KakaoConstants.API_KEY
import com.example.assignmentweek3.model.BookSearchData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface BookApiService {

    @Headers("Authorization: KakaoAK $API_KEY")
    @GET("v3/search/book")
    fun searchBooks(
        @Query("query") query: String,
        @Query("sort") sort: String,
        @Query("page") page: Int,
        @Query("size") size: Int,
    ) : Call<BookSearchData>
}