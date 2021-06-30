package com.example.videogamesdatabase.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.videogamesdatabase.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private val viewModel: HomeViewModel by lazy {
        ViewModelProvider(this).get(HomeViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentHomeBinding.inflate(inflater)
        binding.lifecycleOwner = this
        binding.homeFragmentViewModel = viewModel
            binding.gamePhotosGrid.adapter = GridAdapter(OnClickListener{
                viewModel.displayPropertyDetails(it)
                viewModel.navigateToSelectedProperty.observe(viewLifecycleOwner, Observer{
                    if(null != it){
                        this.findNavController().navigate(HomeFragmentDirections.actionShowDetail(it))
                        viewModel.displayPropertyDetailsComplete()
                    }
                })
            })

        return binding.root

    }

}