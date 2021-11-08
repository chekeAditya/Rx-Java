package com.example.rxjavaretrofit.remote

import com.example.rxjavaretrofit.remote.responses.MovieResponseModel
import com.example.rxjavaretrofit.remote.responses.ResultModel
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface APIClient {

    //BASE_URL = https://api.themoviedb.org/3/movie/popular?api_key=2147294b386ecadcb05cd19bcbbdddb9&page=1


    @GET("3/movie/popular/?api_key=2147294b386ecadcb05cd19bcbbdddb9")
    fun getMovieResponse(@Query("page") page: Int): Observable<MovieResponseModel>

}