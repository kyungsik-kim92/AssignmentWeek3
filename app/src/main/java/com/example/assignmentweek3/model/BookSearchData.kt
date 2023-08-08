package com.example.assignmentweek3.model


import com.google.gson.annotations.SerializedName

data class BookSearchData(
    @SerializedName("documents")
    val documents: List<Document>,
    @SerializedName("meta")
    val meta: Meta
)