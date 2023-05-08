package com.insurance.policyService.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class HomeInsurancePolicy(

    @Id
    val planCode: String, //
    val planName: String,
    val planType: String, //Building or HouseHoldItems or Both
    val planFeatures: List<String>,
    val basePrice: Int,
    var totalPrice : Int = 0

)