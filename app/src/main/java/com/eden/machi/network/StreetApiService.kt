package com.eden.machi.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.Query


private const val BASE_URL = "http://192.168.3.6:8000/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface StreetImageApiService {
    @GET("streetimage")
    suspend fun getImages(@Query("lat") lat : Float,
                          @Query("lng") lng : Float): List<StreetImageProperty>
}

object StreetImageApi {
    val retrofitService : StreetImageApiService by lazy {
        retrofit.create(StreetImageApiService::class.java) }
}