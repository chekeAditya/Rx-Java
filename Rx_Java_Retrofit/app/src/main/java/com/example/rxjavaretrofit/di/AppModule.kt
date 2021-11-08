package com.example.rxjavaretrofit.di

import com.example.rxjavaretrofit.remote.APIClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object AppModule {

    //BASE_URL = https://api.themoviedb.org/3/movie/popular?api_key=2147294b386ecadcb05cd19bcbbdddb9&page=1

    const val BASE_URL = "https://api.themoviedb.org/"

    fun getRetrofitResponse() = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .build()

    fun getAPIService() = getRetrofitResponse().create(APIClient::class.java)

}