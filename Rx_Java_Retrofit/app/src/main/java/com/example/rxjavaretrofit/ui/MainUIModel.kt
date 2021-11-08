package com.example.rxjavaretrofit.ui

import com.example.rxjavaretrofit.remote.responses.ResultModel


sealed class MainUIModel {

    data class OnSuccess(val resultList: List<ResultModel>) : MainUIModel()

    data class onFailure(val error: String) : MainUIModel()

}