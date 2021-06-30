package com.example.videogamesdatabase

import android.view.View
import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.videogamesdatabase.home.ApiServiceStatus
import com.example.videogamesdatabase.home.GridAdapter
import com.example.videogamesdatabase.network.GameProperty

    /**
     * Uses the Glide library to load an image by URL into an [ImageView]
     */

    @BindingAdapter("imageUrl")
    fun bindImage(imgView: ImageView, imgUrl: String?) {
        imgUrl?.let {
            val imgUri =
                imgUrl.toUri().buildUpon().scheme("https").build()
            Glide.with(imgView.context)
                .load(imgUri)
                .apply(
                    RequestOptions()
                        .placeholder(R.drawable.ic_loading_animation)
                        .error(R.drawable.ic_baseline_broken_image_24)
                )
                .into(imgView)
        }
    }


    /**
     * This binding adapter displays the ApiServiceStatus of the network request in an image view.  When
     * the request is loading, it displays a loading_animation.  If the request has an error, it
     * displays a broken image to reflect the connection error.  When the request is finished, it
     * hides the image view.
     */
    @BindingAdapter("ApiServiceStatus")
    fun bindStatus(
        statusImageView: ImageView,
        status: ApiServiceStatus?
    ) {
        when (status) {
            ApiServiceStatus.LOADING -> {
                statusImageView.visibility = View.VISIBLE
                statusImageView.setImageResource(R.drawable.ic_loading_animation)
            }
            ApiServiceStatus.ERROR -> {
                statusImageView.visibility = View.VISIBLE
                statusImageView.setImageResource(R.drawable.ic_connection_error)
            }
            ApiServiceStatus.DONE -> {
                statusImageView.visibility = View.GONE
            }
        }
    }

    /**
     * When there is no Gallery data (data is null), hide the [RecyclerView], otherwise show it.
     */
    @BindingAdapter("listData")
    fun bindRecyclerView(recyclerView: RecyclerView, data: List<GameProperty>?) {
        val adapter = recyclerView.adapter as GridAdapter
        adapter.submitList(data)
    }
