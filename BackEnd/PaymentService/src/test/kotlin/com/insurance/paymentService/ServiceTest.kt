package com.insurance.paymentService

import com.insurance.paymentService.model.PaymentDetails
import com.insurance.paymentService.repository.PaymentRepo
import com.insurance.paymentService.serviceImpl.PaymentServiceImpl
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import reactor.test.StepVerifier
import java.time.LocalDate
import java.time.LocalTime

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

class ServiceTest (
    @Autowired private var service : PaymentServiceImpl,
    @Autowired private var repo : PaymentRepo
) {

    val payment = PaymentDetails("ABC",500000,"Debit Card",
        "","", LocalDate.parse("2014-11-25"), LocalTime.parse("12:34:56"))
    val payMono = Mono.just(payment);

    @BeforeEach
    fun set(){
        repo = Mockito.mock(PaymentRepo::class.java)
        service = PaymentServiceImpl(repo)
    }

    @Test
    fun shouldAddPayment() {
        Mockito.`when`(repo.insert(payment)).thenReturn(Mono.just(payment))

        StepVerifier.create(service.addPayment(payMono))
            .expectSubscription()
            .expectNext(payment)
            .verifyComplete()
    }

    @Test
    fun shouldViewAllPayments() {
        Mockito.`when`(repo.findAll()).thenReturn(Flux.just(payment))

        StepVerifier.create(service.viewAllPayments())
            .expectSubscription()
            .expectNext(payment)
            .verifyComplete()
    }

    @Test
    fun shouldViewById() {
        Mockito.`when`(repo.findById("ABC")).thenReturn(Mono.just(payment))

        StepVerifier.create(service.viewById("ABC"))
            .expectSubscription()
            .expectNext(payment)
            .verifyComplete()
    }




}