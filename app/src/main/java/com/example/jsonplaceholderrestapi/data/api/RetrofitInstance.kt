package com.example.jsonplaceholderrestapi.data.api

import com.example.jsonplaceholderrestapi.util.Constants.Companion.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object RetrofitInstance {
    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }
    val jsonPlaceHolderAPIService: JsonPlaceHolderAPIService by lazy {
        retrofit.create(JsonPlaceHolderAPIService::class.java)
    }
}