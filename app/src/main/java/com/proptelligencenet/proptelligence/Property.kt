package com.proptelligencenet.proptelligence

data class Property(val imageId: Int, val name: String, val address: String, val price: String, val location: String)


object PropertyRepository {
    val properties = listOf(
        Property(R.drawable.agreement_drafting, "Property 1", "Address 1", "Price 1", "Location 1"),
        Property(R.drawable.affidavits_legal, "Property 2", "Address 2", "Price 2", "Location 2"),
        // Add more properties...
    )
}