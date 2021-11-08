package com.application.newsbreeze.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.application.newsbreeze.remote.responses.Article
import com.application.newsbreeze.repositories.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

@HiltViewModel
class ViewModelApp @Inject constructor(var repository: Repository) : ViewModel() {

    fun getDataFromApi(): LiveData<List<Article>> {
        return liveData(Dispatchers.IO) {
            emit(repository.getResponse())
        }
    }
}