package com.insurance.customerService.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.util.Date

data class PolicyDetails(

    val policyCode : String?,
//    val email:String,
    val planCode : String,
    val policyType : String,
    val policyStatus : String,
    val durationInYears: Int,
    val startDate: Date,
    val endDate: Date,
    val policyCover : Int,
    val totalPremium: Int,
    val monthlyInstallment: Int,

)