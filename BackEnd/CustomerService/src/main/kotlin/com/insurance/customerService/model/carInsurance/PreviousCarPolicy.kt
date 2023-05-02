package com.insurance.customerService.model.carInsurance

import java.util.Date

data class PreviousCarPolicy(
    val policyNumber : String,
    val vendor : String,
    val expiryDate : Date,

) {
}