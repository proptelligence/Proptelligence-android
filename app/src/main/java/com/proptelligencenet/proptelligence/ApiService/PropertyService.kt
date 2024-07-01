package com.proptelligencenet.proptelligence.ApiService

import retrofit2.http.GET

interface PropertyService {
    @GET("properties/Hyderabad")
    suspend fun getHyderabadProperties(): CitiesInfo

    @GET("properties/Mumbai")
    suspend fun getMumbaiProperties(): CitiesInfo

    @GET("properties/Ahmedabad")
    suspend fun getAhmedabadProperties(): CitiesInfo

    @GET("properties/Bangalore")
    suspend fun getBangaloreProperties(): CitiesInfo

    @GET("properties/Chennai")
    suspend fun getChennaiProperties(): CitiesInfo

    @GET("properties/Delhi")
    suspend fun getDelhiProperties(): CitiesInfo

    @GET("properties/Kolkata")
    suspend fun getKolkataProperties(): CitiesInfo

    @GET("properties/Pune")
    suspend fun getPuneProperties(): CitiesInfo
}