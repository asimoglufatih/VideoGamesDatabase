package com.example.videogamesdatabase.favourites

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.videogamesdatabase.databinding.FragmentFavouritesBinding


class FavouritesFragment : Fragment() {

    private val favouritesViewModel: FavouritesViewModel by lazy {
        ViewModelProvider(this).get(FavouritesViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentFavouritesBinding.inflate(inflater)
        binding.lifecycleOwner = this
        binding.viewModel = favouritesViewModel

        return binding.root


    }

}