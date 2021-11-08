package com.application.newsbreeze.repositories

import androidx.lifecycle.LiveData
import com.application.newsbreeze.remote.APIClient
import com.application.newsbreeze.remote.responses.Article
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import javax.inject.Inject

class Repository @Inject constructor(private val apiClient: APIClient) {

    suspend fun getResponse():List<Article>{
        return apiClient.getApiResponse().articles
    }

}