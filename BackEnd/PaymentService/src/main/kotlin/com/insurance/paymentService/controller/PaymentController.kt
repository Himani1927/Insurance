package com.insurance.paymentService.controller

import com.insurance.paymentService.model.PaymentDetails
import com.insurance.paymentService.service.PaymentService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/maxinsure/payment")
class PaymentController(
    private val service: PaymentService
) {

    @PostMapping()
    fun makePayment(payment : Mono<PaymentDetails>) : Mono<PaymentDetails> = service.addPayment(payment)

    @GetMapping()
    fun getAllPayments() : Flux<PaymentDetails> = service.viewAllPayments()

    @GetMapping("/{policyCode}")
    fun getById( id : String) : Mono<PaymentDetails> = service.viewById(id)
}