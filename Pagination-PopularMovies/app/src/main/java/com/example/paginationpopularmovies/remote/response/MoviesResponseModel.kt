package com.example.paginationpopularmovies.remote.response


import com.google.gson.annotations.SerializedName

data class MoviesResponseModel(
    @SerializedName("page")
    val page: Int,
    @SerializedName("results")
    val resultModels: List<ResultModel>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
)