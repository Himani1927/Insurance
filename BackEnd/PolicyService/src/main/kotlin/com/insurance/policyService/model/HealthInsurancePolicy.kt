package com.insurance.policyService.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document


@Document
data class HealthInsurancePolicy(

    @Id
    val planCode: String,
    val planName: String,
    var planFeatures : List<String>,
    var planCover : Int,
    val basePrice: Int,
    val totalCost : Int = 0,
    val costWithGst : Int = 0

)