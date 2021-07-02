package com.example.videogamesdatabase.favourites

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.videogamesdatabase.network.GameProperty

class FavouritesViewModel: ViewModel() {

    private val _favouriteProperties = MutableLiveData<List<GameProperty>>()
    val favouriteProperties: LiveData<List<GameProperty>>
        get() = _favouriteProperties


}