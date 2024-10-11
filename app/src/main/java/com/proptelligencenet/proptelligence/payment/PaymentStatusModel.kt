package com.proptelligencenet.proptelligence.payment

data class PaymentStatusModel(
    val cf_order_id: String? = null,
    val entity: String? = null,
    val order_amount: Double? = null,
    val order_status: String? = null
)
