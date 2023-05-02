package com.insurance.customerService.model

import com.insurance.customerService.model.carInsurance.CustomerCarDetails
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class CustomerDetails(

    @Id
    var id : String?,
    var customerFirstName : String,
    var customerLastName : String,
    var customerEmail : String,
    var contactNumber : String,
    var customerCarDetails: CustomerCarDetails?
) {
}