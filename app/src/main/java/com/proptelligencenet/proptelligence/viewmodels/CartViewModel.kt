package com.proptelligencenet.proptelligence.viewmodels

import android.content.Context
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.cashfree.pg.api.CFPaymentGatewayService
import com.cashfree.pg.base.exception.CFException
import com.cashfree.pg.core.api.CFSession
import com.cashfree.pg.core.api.webcheckout.CFWebCheckoutPayment
import com.cashfree.pg.core.api.webcheckout.CFWebCheckoutTheme
import com.proptelligencenet.proptelligence.ApiService.NetworkModule
import com.proptelligencenet.proptelligence.ApiService.PaymentAPI.PaymentAPI
import com.proptelligencenet.proptelligence.SignIn.UserData
import com.proptelligencenet.proptelligence.cart.Product
import com.proptelligencenet.proptelligence.payment.Data
import com.proptelligencenet.proptelligence.payment.PaymentModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CartViewModel : ViewModel() {

    val cart = mutableStateListOf<Product>()
    val paymentSessionUrl = mutableStateOf<String?>(null)

    fun addToCart(product: Product) {
        cart.add(product)
    }

    fun removeFromCart(product: Product) {
        cart.remove(product)
    }

    fun clearCart() {
        cart.clear()
    }

    fun createPayment(context: Context) {
        PaymentAPI.createOrder()?.getOrderID(
            Data(
                order_amount = cart.sumBy { it.price }.toDouble(),
                order_currency = "INR",
                customer_details = UserData(
                    customer_id = "sac1245",
                    customer_name = "Sachin",
                    customer_email = "sachin@gmail.com",
                    customer_phone = "+917738878697"
                )
            )
        )?.enqueue(object : Callback<PaymentModel> {
            override fun onResponse(call: Call<PaymentModel>, response: Response<PaymentModel>) {
                response.body()?.let {
                    doPayment(context, it)
                }
            }

            override fun onFailure(call: Call<PaymentModel>, t: Throwable) {
                // Handle error
                println("Error creating payment: ${t.message}")
            }
        })
    }

    private fun doPayment(context: Context, response: PaymentModel) {
        try {
            val cfSession = CFSession.CFSessionBuilder()
                .setEnvironment(CFSession.Environment.SANDBOX)
                .setPaymentSessionID(response.paymentSessionId!!)
                .setOrderId(response.orderId!!)
                .build()
            val cfTheme = CFWebCheckoutTheme.CFWebCheckoutThemeBuilder()
                .setNavigationBarBackgroundColor("#fc2678")
                .setNavigationBarTextColor("#ffffff")
                .build()
            val cfWebCheckoutPayment = CFWebCheckoutPayment.CFWebCheckoutPaymentBuilder()
                .setSession(cfSession)
                .setCFWebCheckoutUITheme(cfTheme)
                .build()

            CFPaymentGatewayService.getInstance()
                .doPayment(context, cfWebCheckoutPayment)
        } catch (exception: CFException) {
            exception.printStackTrace()
        }
    }
}

