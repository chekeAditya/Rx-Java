package com.masai.pagingnetworkand03

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.masai.pagingnetworkand03.ui.CharacterAdapter
import com.masai.pagingnetworkand03.ui.CharacterViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var characterViewModel: CharacterViewModel
    private lateinit var characterAdapter: CharacterAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        characterViewModel = ViewModelProvider(this).get(CharacterViewModel::class.java)
        setAdapter()

        characterViewModel.searchCharacters().observe(this, Observer {
            it?.let {
                CoroutineScope(Main).launch {
                    characterAdapter.submitData(it)
                }
            }
        })

    }

    private fun setAdapter() {
        characterAdapter = CharacterAdapter()
        val linearLayoutManager = LinearLayoutManager(this)
        recyclerview.apply {
            layoutManager = linearLayoutManager
            this.adapter = characterAdapter
        }
    }
}
