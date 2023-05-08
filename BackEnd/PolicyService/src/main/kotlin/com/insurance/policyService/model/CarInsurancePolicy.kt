package com.insurance.policyService.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class CarInsurancePolicy(

    @Id
    val planCode : String,
    val planName : String,
    val carType : String, //SUV, SEDAN, HATCHBACK
    var planFeatures : List<String>,
    val basePrice : Int,

)