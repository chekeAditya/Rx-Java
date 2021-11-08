package com.example.rxjavaretrofit.repositorys;

import com.example.rxjavaretrofit.di.AppModule;
import com.example.rxjavaretrofit.remote.APIClient;

public class AppPagingSourceOne {

    APIClient apiClient = AppModule.INSTANCE.getAPIService();



}
