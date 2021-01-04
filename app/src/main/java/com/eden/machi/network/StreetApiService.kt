package com.eden.machi.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.Query


private const val BASE_URL = "https://localhost:8080/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface StreetImageApiService {
    @GET("streetimage")
    suspend fun getImages(@Query("lon") lon : Float, @Query("lat") lat : Float): List<StreetImageProperty>
}

object StreetImageApi {
    val retrofitService : StreetImageApiService by lazy {
        retrofit.create(StreetImageApiService::class.java) }
}