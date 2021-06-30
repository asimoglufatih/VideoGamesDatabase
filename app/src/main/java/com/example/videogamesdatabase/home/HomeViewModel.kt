package com.example.videogamesdatabase.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.videogamesdatabase.network.GameProperty
import com.example.videogamesdatabase.network.GamesApi
import kotlinx.coroutines.launch
import java.lang.Exception

enum class ApiServiceStatus {LOADING, ERROR, DONE}

class HomeViewModel: ViewModel(){

    private val _status = MutableLiveData<ApiServiceStatus>()
    val status: LiveData<ApiServiceStatus>
        get() = _status

    private val _properties = MutableLiveData<List<GameProperty>>()
    val properties: LiveData<List<GameProperty>>
        get() = _properties

    private val _navigateToSelectedProperty = MutableLiveData<GameProperty>()
    val navigateToSelectedProperty: LiveData<GameProperty>
        get() = _navigateToSelectedProperty

    init{
        getGamesProperties()
    }


    private fun getGamesProperties(){
        viewModelScope.launch {
            _status.value = ApiServiceStatus.LOADING
            try {
                _properties.value = GamesApi.retrofitService.getProperties()
                _status.value = ApiServiceStatus.DONE
            }catch (e: Exception){
                _status.value = ApiServiceStatus.ERROR
                _properties.value = ArrayList()
            }
        }
    }

    fun displayPropertyDetails(gameProperty: GameProperty){
        _navigateToSelectedProperty.value = gameProperty
    }

    fun displayPropertyDetailsComplete(){
        _navigateToSelectedProperty.value = null
    }



}