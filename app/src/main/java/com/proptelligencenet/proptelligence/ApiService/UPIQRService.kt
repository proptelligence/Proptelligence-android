package com.proptelligencenet.proptelligence.ApiService

import retrofit2.http.GET
import retrofit2.http.Query

interface UPIQRService {
    @GET("qr")
    suspend fun getQRCode(
        @Query("name") name: String,
        @Query("vpa") vpa: String,
        @Query("note") note: String? = null,
        //@Query("amount") amount: String? = null,
        @Query("format") format: String = "png",
    ): QRResponse
}