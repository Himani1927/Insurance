package com.insurance.paymentService.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDate
import java.time.LocalTime

@Document
data class PaymentDetails(

    @Id
    val policyCode : String, // take from policyDetails
    val paymentAmount : Int,
    val paymentMode : String, // Debit-card, credit-card , net-banking
    val paymentStatus : String?,
    val transactionId : String?,
    val paymentDate : LocalDate?,
    val paymentTime : LocalTime?,

)
