package com.example.paginationpopularmovies.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig

class MoviesRepository {
    fun getPagesList() = Pager(
        config = PagingConfig(
            pageSize = 20,
//            maxSize = (MAX_SIZE_UNBOUND) 70 //it will drop(delete) after 70 page's done
//            prefetchDistance =  // it will tell how much data will be needed for advanced
        ),
        pagingSourceFactory = {  }
    ).liveData
}