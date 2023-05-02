package com.insurance.customerService.model.carInsurance

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class CustomerCarDetails (
    @Id
    val regNumber : String,
    var ownerName : String,
    val purchaseYear : Int,
    val carDetails: CarDetails
) {
}