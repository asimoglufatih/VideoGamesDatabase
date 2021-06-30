package com.example.videogamesdatabase.detail

import android.app.Application
import androidx.lifecycle.HasDefaultViewModelProviderFactory
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.videogamesdatabase.network.GameProperty

class DetailViewModelFactory(
    private val gameProperty: GameProperty,
    private val application: Application
    ):ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DetailViewModel::class.java)) {
            return DetailViewModel(gameProperty, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}