package com.masai.pagingnetworkand03.ui

import androidx.lifecycle.ViewModel

class CharacterViewModel : ViewModel() {

    private val repository =  CharacterRepository()

    fun searchCharacters() =
        repository.getPagesList()

}