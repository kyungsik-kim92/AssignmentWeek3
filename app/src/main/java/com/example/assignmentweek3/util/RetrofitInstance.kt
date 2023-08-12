package com.example.assignmentweek3.util

import com.example.assignmentweek3.api.BookApiService
import com.example.assignmentweek3.constants.KakaoConstants.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitInstance {
    private val retrofit: Retrofit
        get() = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    val api: BookApiService by lazy {
        retrofit.create(BookApiService::class.java)
    }
}