package com.insurance.customerService.model

import java.time.LocalDate

data class PolicyDetails(

    val policyCode : String?,
//    val email:String,
    val planCode : String,
    val policyStatus : String?,
    val durationInYears: Int,
    val startDate: LocalDate?,
    val endDate: LocalDate?,
    val policyCover : Int,
    val totalPremium: Int,

    )