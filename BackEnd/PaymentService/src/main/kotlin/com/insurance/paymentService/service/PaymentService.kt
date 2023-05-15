package com.insurance.paymentService.service

import com.insurance.paymentService.model.PaymentDetails
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface PaymentService {

    fun addPayment(payment : Mono<PaymentDetails>) : Mono<PaymentDetails>
    fun viewAllPayments() : Flux<PaymentDetails>
    fun viewById( id : String) : Mono<PaymentDetails>

}