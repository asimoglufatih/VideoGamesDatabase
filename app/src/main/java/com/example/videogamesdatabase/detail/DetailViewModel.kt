package com.example.videogamesdatabase.detail

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.example.videogamesdatabase.R
import com.example.videogamesdatabase.network.GameProperty

class DetailViewModel(gameProperty: GameProperty,
                      app: Application
) : AndroidViewModel(app) {

    private val _selectedProperty = MutableLiveData<GameProperty>()
    val selectedProperty: LiveData<GameProperty>
        get() = _selectedProperty

    init{
        _selectedProperty.value = gameProperty
    }

    val displayDestination = Transformations.map(selectedProperty) {
        app.applicationContext.getString(
            R.string.destination,
            it.destination
        )
    }

    val displayName = Transformations.map(selectedProperty) {
        app.applicationContext.getString(
            R.string.name,
            it.name
        )
    }
}