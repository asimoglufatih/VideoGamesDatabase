package com.example.videogamesdatabase.network

import com.squareup.moshi.Json

data class GameProperty(
//    val id: String,
//    val name: String,
//    val releaseDate: String,
//    val metacriticRate: String,
//    @Json(name= "imageurl") val imgSrcUrl: String,
//    val description: String)

    val id: String,
    val name: String,
    val propellant: String,
    val destination: String,
    @Json(name = "imageurl") val imgSrcUrl: String,
    val technologyexists: String)

