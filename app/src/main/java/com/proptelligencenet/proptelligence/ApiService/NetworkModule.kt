package com.proptelligencenet.proptelligence.ApiService

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkModule {
    private const val BASE_URL = "https://property-backend-9abo.onrender.com/"

    private val retrofit: Retrofit by lazy {Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    }

    fun getPropertyService(): PropertyService {
        return retrofit.create(PropertyService::class.java)
    }
}