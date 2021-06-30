package com.example.videogamesdatabase.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.videogamesdatabase.databinding.FragmentDetailBinding

class DetailFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val application = requireNotNull(activity).application
        val binding = FragmentDetailBinding.inflate(inflater)

        val gameProperty = DetailFragmentArgs.fromBundle(requireArguments()).selectedProperty
        val viewModelFactory = DetailViewModelFactory(gameProperty, application)

        binding.detailViewModel = ViewModelProvider(
            this, viewModelFactory).get(DetailViewModel::class.java)

        binding.lifecycleOwner = this


        return binding.root
    }


}