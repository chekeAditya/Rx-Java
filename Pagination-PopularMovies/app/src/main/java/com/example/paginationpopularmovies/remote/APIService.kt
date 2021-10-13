package com.example.paginationpopularmovies.remote

import retrofit2.http.GET
import retrofit2.http.Query

interface APIService {

    //URL:- https://api.themoviedb.org/3/movie/popular?api_key=2147294b386ecadcb05cd19bcbbdddb9&page=1

    companion object {
        const val BASE_URL = "https://api.themoviedb.org/3/"
    }

    @GET("movie/popular?api_key=2147294b386ecadcb05cd19bcbbdddb9")
    suspend fun getMoviesResponse(@Query("page") page : Int )

}