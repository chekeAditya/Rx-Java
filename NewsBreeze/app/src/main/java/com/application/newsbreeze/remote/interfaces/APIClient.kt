package com.application.newsbreeze.remote.interfaces

import com.application.newsbreeze.remote.responses.ResponseModell
import retrofit2.http.GET
import retrofit2.http.Query

interface APIClient {

    //https://newsapi.org/v2/top-headlines?country=us&apiKey=cb048cd738504d8e9b073176ba23ddae
    @GET("v2/top-headlines?country=us&apiKey=cb048cd738504d8e9b073176ba23ddae")
    suspend fun getApiResponse():ResponseModell
}