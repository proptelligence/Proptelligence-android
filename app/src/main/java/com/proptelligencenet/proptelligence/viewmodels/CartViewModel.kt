package com.proptelligencenet.proptelligence.viewmodels

import android.content.Context
import android.widget.Toast
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.cashfree.pg.api.CFPaymentGatewayService
import com.cashfree.pg.base.exception.CFException
import com.cashfree.pg.core.api.CFSession
import com.cashfree.pg.core.api.callback.CFCheckoutResponseCallback
import com.cashfree.pg.core.api.utils.CFErrorResponse
import com.cashfree.pg.core.api.webcheckout.CFWebCheckoutPayment
import com.cashfree.pg.core.api.webcheckout.CFWebCheckoutTheme
import com.cashfree.pg.ui.api.upi.intent.CFIntentTheme
import com.cashfree.pg.ui.api.upi.intent.CFUPIIntentCheckout
import com.cashfree.pg.ui.api.upi.intent.CFUPIIntentCheckoutPayment
import com.proptelligencenet.proptelligence.ApiService.NetworkModule
import com.proptelligencenet.proptelligence.ApiService.PaymentAPI.PaymentAPI
import com.proptelligencenet.proptelligence.ApiService.PaymentAPI.PaymentStatusAPI
import com.proptelligencenet.proptelligence.SignIn.UserData
import com.proptelligencenet.proptelligence.cart.Product
import com.proptelligencenet.proptelligence.payment.Data
import com.proptelligencenet.proptelligence.payment.PaymentModel
import com.proptelligencenet.proptelligence.payment.PaymentStatusModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.Arrays

class CartViewModel : ViewModel(), CFCheckoutResponseCallback {


    val cart = mutableStateListOf<Product>()
    val paymentSessionUrl = mutableStateOf<String?>(null)
    val paymentStatus = mutableStateOf<String?>(null) // Holds the payment status for the UI


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
        try {
            // Register the CartViewModel as the payment callback
            CFPaymentGatewayService.getInstance().setCheckoutCallback(this)

            // Call the API to create a payment order
            PaymentAPI.createOrder()?.getOrderID(
                Data(
                    order_amount = cart.sumBy { it.price }.toDouble(),  // Calculate the total amount
                    order_currency = "INR",
                    customer_details = UserData(
                        customer_id = "sac1245",
                        customer_name = "test",
                        customer_email = "test@gmail.com",
                        customer_phone = "+917972353637"
                    )
                )
            )?.enqueue(object : Callback<PaymentModel> {
                override fun onResponse(call: Call<PaymentModel>, response: Response<PaymentModel>) {
                    // If the API responds successfully, start the payment process
                    if (response.isSuccessful && response.body() != null) {
                        doPayment(context, response.body()!!)
                    } else {
                        // Handle error: Response not successful or body is null
                        paymentStatus.value = "Failed to create order: ${response.message()}"
                    }
                }

                override fun onFailure(call: Call<PaymentModel>, t: Throwable) {
                    // Handle failure in the order creation
                    paymentStatus.value = "Error creating order: ${t.message}"
                }
            })
        } catch (e: CFException) {
            // Handle CFException
            paymentStatus.value = "Error: ${e.message}"
            e.printStackTrace()
        }
    }


    private fun doPayment(context: Context, response: PaymentModel) {
        try {
            val cfSession = CFSession.CFSessionBuilder()
                .setEnvironment(CFSession.Environment.SANDBOX)
                .setPaymentSessionID(response.paymentSessionId!!)  // Make sure this is not null
                .setOrderId(response.orderId!!)  // Ensure order ID is not null
                .build()

            val cfTheme = CFWebCheckoutTheme.CFWebCheckoutThemeBuilder()
                .setNavigationBarBackgroundColor("#fc2678")
                .setNavigationBarTextColor("#ffffff")
                .build()

            val cfWebCheckoutPayment = CFWebCheckoutPayment.CFWebCheckoutPaymentBuilder()
                .setSession(cfSession)
                .setCFWebCheckoutUITheme(cfTheme)
                .build()


            val cfUPITheme = CFIntentTheme.CFIntentThemeBuilder()
                .setPrimaryTextColor("#000000")
                .setBackgroundColor("#FFFFFF")
                .build()
            val cfupiIntentCheckout =
                CFUPIIntentCheckout.CFUPIIntentBuilder() // Use either the enum or the application package names to order the UPI apps as per your needed
                    // Remove both if you want to use the default order which cashfree provides based on the popularity
                    // NOTE - only one is needed setOrder or setOrderUsingPackageName
                    .setOrderUsingPackageName(Arrays.asList("com.dreamplug.androidapp", "in.org.npci.upiapp"))
                    .setOrder(Arrays.asList(CFUPIIntentCheckout.CFUPIApps.BHIM, CFUPIIntentCheckout.CFUPIApps.PHONEPE))
                    .build()
            val cfupiIntentCheckoutPayment = CFUPIIntentCheckoutPayment.CFUPIIntentPaymentBuilder()
                .setSession(cfSession)
                .setCfUPIIntentCheckout(cfupiIntentCheckout)
                .setCfIntentTheme(cfUPITheme)
                .build()

            // Trigger the payment process
            CFPaymentGatewayService.getInstance().doPayment(context, cfWebCheckoutPayment)
        } catch (exception: CFException) {
            // Handle payment exception
            paymentStatus.value = "Error during payment: ${exception.message}"
            exception.printStackTrace()
        }
    }



    // Called when the payment is successful and needs verification
    override fun onPaymentVerify(orderKey: String?) {
        getPaymentStatus(orderKey!!)
    }

    // Called when the payment fails
    override fun onPaymentFailure(errorResponse: CFErrorResponse?, message: String?) {
        paymentStatus.value = "Payment failed: ${errorResponse?.message ?: message}"
    }

    // Fetches the payment status from the server
    fun getPaymentStatus(orderKey: String) {
        PaymentStatusAPI.getPaymentStatus()?.create(orderKey)
            ?.enqueue(object : Callback<PaymentStatusModel> {
                override fun onResponse(
                    call: Call<PaymentStatusModel>,
                    response: Response<PaymentStatusModel>
                ) {
                    if (response.body()?.order_status == "PAID") {
                        paymentStatus.value = "Payment complete."
                    } else {
                        paymentStatus.value = "Payment is pending."
                    }
                }

                override fun onFailure(call: Call<PaymentStatusModel>, t: Throwable) {
                    paymentStatus.value = "Error fetching payment status: ${t.message}"
                }
            })
    }
}

