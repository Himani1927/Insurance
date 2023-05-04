package com.insurance.policyService.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class Policies(

    @Id
    val id: String?,
    val policyCode: String,
    var policyType: String,
    var policyCover: Double,
    var policyDuration: Int,
    var policyPremiumYearly: Double,
    var policyPremiumMonthly: Double,
    var policyDescription: String,
    var policyFeatures: List<String>,

)