package com.application.newsbreeze.repositories

import com.application.newsbreeze.remote.interfaces.APIClient
import com.application.newsbreeze.remote.responses.Article
import javax.inject.Inject

class Repository @Inject constructor(private val apiClient: APIClient) {

    suspend fun getResponse():List<Article>{
        return apiClient.getApiResponse().articles
    }

}