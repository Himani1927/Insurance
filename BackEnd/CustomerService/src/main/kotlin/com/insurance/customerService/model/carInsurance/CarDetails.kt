package com.insurance.customerService.model.carInsurance

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class CarDetails(
    @Id
    val id: String?,
    var carType:String,
    var brand:String,
    var model:String,
    var fuelType:String,
    var variant:String,
    var engine:String
)