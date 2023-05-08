package com.insurance.customerService.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.DBRef
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class HomeInsurance(

    @Id
    val id: String?,
    val email: String,
    val firstName: String,
    val lastName: String,
    var contactNo: String,
    var propertyAddress: String,
    var propertyCity : String,
    val propertyPincode: String,
    val propertyState: String,
    var isPresentAddress: Boolean ? = true,
    val communicationAddress : String ,
    val communicationCity: String,
    val communicationPincode: String,
    val communicationState: String,
    val propertyType: String,
    val residentType: String,
    var insureBuilding: Boolean? = false,
    var buildingValue: Int? = 0,
    var insureHouseholdItems: Boolean? = false,
    var itemsValue: Int ? = 0,

    var policyDetails: PolicyDetails,

)
