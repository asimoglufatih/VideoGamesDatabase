package com.example.videogamesdatabase.network

import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize
import android.os.Parcelable

@Parcelize
data class GameProperty(

//    val id: Int,
//    val name: String,
//    val released: String,
//    val rating: Int,
//    @Json(name = "background_image") val imgSrcUrl: String):Parcelable

    val id: String,
    val name: String,
    val propellant: String,
    val isAddedFavourite: Boolean = false,
    val destination: String,
    @Json(name = "imageurl") val imgSrcUrl: String,
    val technologyexists: String):Parcelable

