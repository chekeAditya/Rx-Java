package com.application.newsbreeze.remote.responses


import com.google.gson.annotations.SerializedName

data class ResponseModell(
    @SerializedName("articles")
    val articles: List<Article>,
    @SerializedName("status")
    val status: String,
    @SerializedName("totalResults")
    val totalResults: Int
)