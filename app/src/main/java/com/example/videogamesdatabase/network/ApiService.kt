package com.example.videogamesdatabase.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Header

//https://rawg-video-games-database.p.rapidapi.com/
//ttps://google-reverse-image-search.p.rapidapi.com/
//https://raw.githubusercontent.com/
//Oclemy/SampleJSON/338d9585/spacecrafts.json
private const val BASE_URL = "https://raw.githubusercontent.com/"


private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()


interface ApiService {
    @GET("Oclemy/SampleJSON/338d9585/spacecrafts.json")
    suspend fun getProperties():
            List<GameProperty>
}

object GamesApi {
    val retrofitService : ApiService by lazy {
        retrofit.create(ApiService::class.java) }
}
