package com.proptelligencenet.proptelligence.ApiService.PaymentAPI

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object PaymentStatusAPI {

    private var retrofit: Retrofit? = null

    fun getPaymentStatus():PaymentStatusInterface?{
        if (retrofit == null){
            retrofit = Retrofit.Builder()
                .baseUrl("https://api.cashfree.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return retrofit!!.create(PaymentStatusInterface::class.java)
    }
}