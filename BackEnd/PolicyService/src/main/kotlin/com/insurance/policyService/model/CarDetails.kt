package com.insurance.policyService.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class CarDetails(

    @Id
    val carId: Int?,
    val carBrand:String,
    val carType:String,
    val modelName:String,
    val fuelType:String,
    val variantName:String,

)