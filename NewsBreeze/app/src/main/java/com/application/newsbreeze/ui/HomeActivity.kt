package com.application.newsbreeze.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.application.newsbreeze.R
import com.application.newsbreeze.viewmodels.ViewModelApp
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
    }
}