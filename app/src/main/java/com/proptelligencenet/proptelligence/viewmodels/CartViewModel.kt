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
import com.google.firebase.auth.FirebaseAuth
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
import kotlin.math.log

class CartViewModel : ViewModel(), CFCheckoutResponseCallback {

    val cart = mutableStateListOf<Product>()
    val paymentStatus = mutableStateOf<String?>(null)
    var userData = mutableStateOf(UserData()) // Holds the user data from the form
    var isPaymentFormVisible = mutableStateOf(false) // Control the form visibility



    // Method to toggle payment form visibility
    fun togglePaymentForm() {
        isPaymentFormVisible.value = !isPaymentFormVisible.value
    }

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
            CFPaymentGatewayService.getInstance().setCheckoutCallback(this)

            // Calculate total amount
            val totalAmount = cart.sumOf { it.price }

            // Call the API to create the order
            PaymentAPI.createOrder()?.getOrderID(
                Data(
                    order_amount = totalAmount.toDouble(),
                    order_currency = "INR",
                    customer_details = userData.value
                )
            )?.enqueue(object : Callback<PaymentModel> {
                override fun onResponse(call: Call<PaymentModel>, response: Response<PaymentModel>) {
                    if (response.isSuccessful && response.body() != null) {
                        doPayment(context, response.body()!!)
                    } else {
                        // Log and handle API errors
                        val errorBody = response.errorBody()?.string()
                        paymentStatus.value = "Order creation failed: ${response.message()} - $errorBody"
                        println("Order creation failed: ${response.message()} - $errorBody")

                    }
                }

                override fun onFailure(call: Call<PaymentModel>, t: Throwable) {
                    paymentStatus.value = "Error creating order: ${t.message}"
                }
            })
        } catch (e: CFException) {
            paymentStatus.value = "Error: ${e.message}"
            e.printStackTrace()
        }
    }


    private fun doPayment(context: Context, response: PaymentModel) {
        try {
            val cfSession = CFSession.CFSessionBuilder()
                .setEnvironment(CFSession.Environment.PRODUCTION)
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

            val cfUPITheme = CFIntentTheme.CFIntentThemeBuilder()
                .setPrimaryTextColor("#000000")
                .setBackgroundColor("#FFFFFF")
                .build()

            val cfupiIntentCheckout = CFUPIIntentCheckout.CFUPIIntentBuilder()
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
            paymentStatus.value = "Error during payment: ${exception.message}"
            exception.printStackTrace()
        }
    }

    // Called when the payment is successful and needs verification
    override fun onPaymentVerify(orderKey: String?) {
        orderKey?.let { getPaymentStatus(it) }
    }

    // Called when the payment fails
    override fun onPaymentFailure(errorResponse: CFErrorResponse?, message: String?) {
        paymentStatus.value = "Payment failed: ${errorResponse?.message ?: message}"
    }

    // Fetches the payment status from the server
    private fun getPaymentStatus(orderKey: String) {
        PaymentStatusAPI.getPaymentStatus()?.create(orderKey)
            ?.enqueue(object : Callback<PaymentStatusModel> {
                override fun onResponse(call: Call<PaymentStatusModel>, response: Response<PaymentStatusModel>) {
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
