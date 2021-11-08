package com.example.rxjavaretrofit.repositorys

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.rxjavaretrofit.di.AppModule
import com.example.rxjavaretrofit.remote.APIClient
import com.example.rxjavaretrofit.remote.responses.ResultModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.annotations.NonNull
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers

class AppPagingSource : PagingSource<Int, ResultModel>() {

    private val apiClient: APIClient = AppModule.getAPIService()
    private lateinit var disposable: Disposable

    private
    val resultList = arrayListOf<ResultModel>()


    override fun getRefreshKey(state: PagingState<Int, ResultModel>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ResultModel> {
        val pageNumber = params.key ?: 1
        val movieResponseModel =
            apiClient.getMovieResponse(pageNumber).flatMap { (_, resultModels) ->
                Observable.fromIterable(
                    resultModels
                )
            }.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : Observer<ResultModel?> {
                    override fun onSubscribe(d: @NonNull Disposable?) {
                        d?.let {
                            disposable = d
                        }
                    }

                    override fun onNext(resultsDTOS: @NonNull ResultModel?) {
                        resultsDTOS?.let {
                            resultList.add(it)
                        }
                    }

                    override fun onError(e: @NonNull Throwable?) {
                        Log.d("Aditya", "onError")
                    }

                    override fun onComplete() {
                        val resultModel: ArrayList<ResultModel> = resultList
                        try {
                            LoadResult.Page(
                                data = resultModel,
                                prevKey = null,
                                nextKey = if (resultList.isEmpty()) null else pageNumber + 1
                            )
                        } catch (e: Exception) {
                            LoadResult.Error(e)
                        }
                    }
                })
    }

}