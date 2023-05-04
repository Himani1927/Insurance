package com.insurance.customerService.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.net.Inet4Address

@Document
data class HealthInsurance(

    @Id
    val id: String? ,
    var firstName : String,
    var lastName : String,
    var email : String,
    var contactNo : String,
    var age : Int,
    val gender : String,
    var maritalStatus : String,
    var address: String,
    var city : String,
    var state : String,
    var pincode : Int,
    var height : Int,
    var weight : Int,
    val policyCode : String,


) {
}