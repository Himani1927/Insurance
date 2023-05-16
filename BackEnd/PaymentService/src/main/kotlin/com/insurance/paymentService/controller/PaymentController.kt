package com.insurance.paymentService.controller

import com.insurance.paymentService.model.PaymentDetails
import com.insurance.paymentService.service.PaymentService
import com.insurance.paymentService.serviceImpl.PaymentServiceImpl
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/maxinsure/payment")
@CrossOrigin("http://localhost:3000")
class PaymentController(
    private val service: PaymentServiceImpl
) {

    @PostMapping()
    fun makePayment(@RequestBody payment : Mono<PaymentDetails>) : Mono<PaymentDetails> = service.addPayment(payment).log()

    @GetMapping()
    fun getAllPayments() : Flux<PaymentDetails> = service.viewAllPayments()

    @GetMapping("/{policyCode}")
    fun getById(@PathVariable id : String) : Mono<PaymentDetails> = service.viewById(id)
}