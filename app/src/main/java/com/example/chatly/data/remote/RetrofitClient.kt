package com.example.chatly.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private const val BaseUrl = ""

    val instance : ChatlyApi by lazy {
        Retrofit.Builder().baseUrl(BaseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ChatlyApi::class.java)
    }
}