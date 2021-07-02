package com.example.videogamesdatabase.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers


//?key=dec0e3a64297439f993ce0ae70b3210e

//https://rawg-video-games-database.p.rapidapi.com/
//https://raw.githubusercontent.com/
//Oclemy/SampleJSON/338d9585/spacecrafts.json
//AddHeader("x-rapidapi-key", "f73d634222msh5a53ecc41a7ec12p19350bjsn69d00ddbd6cb")


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
//    @Headers("x-rapidadi-key: dec0e3a64297439f993ce0ae70b3210e",
//    "x-rapidapi-host: rawg-video-games-database.p.rapidapi.com")
    suspend fun getProperties():
            List<GameProperty>
}

object GamesApi {
    val retrofitService : ApiService by lazy {
        retrofit.create(ApiService::class.java) }
}
