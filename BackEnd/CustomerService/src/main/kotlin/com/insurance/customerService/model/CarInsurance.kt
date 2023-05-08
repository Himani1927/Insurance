package com.insurance.customerService.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.DBRef
import org.springframework.data.mongodb.core.mapping.Document
import java.util.*

@Document
data class CarInsurance(

    @Id
    val id : Int?,
    var firstName : String,
    var lastName : String,
    var email : String,
    var contactNo : String,
    val regNumber : String,
    var ownerName : String,
    val engineNumber: String,
    val purchaseYear : Int,
    val rtoCode : String,
    val previousPolicyNumber : String? = null,
    val previousPolicyProvider : String? = null,
    val previousPolicyExpiryDate : Date? = null,
    val carBrand : String,
    val modelName : String,
    val fuelType : String,
    val variantName : String,
    @DBRef
    var policyDetails: PolicyDetails?=null,

)