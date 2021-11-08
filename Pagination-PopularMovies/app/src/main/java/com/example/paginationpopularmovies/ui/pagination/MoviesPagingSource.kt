package com.example.paginationpopularmovies.ui.pagination

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.paginationpopularmovies.remote.di.NetworkHelper
import com.example.paginationpopularmovies.remote.response.MoviesResponseModel
import com.example.paginationpopularmovies.remote.response.ResultModel
import javax.inject.Inject

class MoviesPagingSource @Inject constructor(private val networkHelper: NetworkHelper) :
    PagingSource<Int, MoviesResponseModel>() {

    private  val apiService = NetworkHelper.provideAPIService()

    override fun getRefreshKey(state: PagingState<Int, MoviesResponseModel>): Int? {

    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, MoviesResponseModel> {
        val pageNumber = params.key ?: 1
        val moviesResponseModel: MoviesResponseModel = apiService.getMoviesResponse(pageNumber)
    }

}