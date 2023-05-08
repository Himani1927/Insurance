package com.insurance.customerService.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.DBRef
import org.springframework.data.mongodb.core.mapping.Document
import java.net.Inet4Address

@Document
data class HealthInsurance(

    @Id
    val id: String? ,
    val email : String,
    val firstName : String,
    val lastName : String,
    val contactNo : String,
    var age : Int,
    val gender : String,
    var address: String,
    var city : String,
    var state : String,
    var pincode : Int,
    var height : Int,
    var weight : Int,
    var hasPriorIllness: Boolean,
    var priorIllnessName: String? = null,
    var diagnosisYear: Int? = null,
    var policyDetails: PolicyDetails,
)