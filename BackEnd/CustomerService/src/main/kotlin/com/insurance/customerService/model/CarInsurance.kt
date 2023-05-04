package com.insurance.customerService.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.util.*

@Document
data class CarInsurance(

    @Id
    val id : String?,
    var userFirstName : String,
    var userLastName : String,
    var userEmail : String,
    var userContactNo : String,
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
    val policyCode : String,

)