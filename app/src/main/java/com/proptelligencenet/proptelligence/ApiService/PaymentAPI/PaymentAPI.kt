package com.proptelligencenet.proptelligence.ApiService.PaymentAPI

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object PaymentAPI {

    private var retrofit: Retrofit? = null
    fun createOrder():PaymentInterface?{
        if (retrofit == null){
            retrofit = Retrofit.Builder()
                .baseUrl("https://api.cashfree.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return retrofit!!.create(PaymentInterface::class.java)
    }
}