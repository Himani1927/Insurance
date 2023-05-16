package com.insurance.paymentService.serviceImpl

import com.insurance.paymentService.model.PaymentDetails
import com.insurance.paymentService.repository.PaymentRepo
import com.insurance.paymentService.service.PaymentService
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.format.DateTimeFormatter
import kotlin.random.Random

@Service
class PaymentServiceImpl(
    private val repo : PaymentRepo
) : PaymentService {


    private fun generatedId(): String {
        val currDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"))
        val random = Random.nextInt(100000,999999)
        return "TXN$currDate$random"
    }

    override fun addPayment(payment: Mono<PaymentDetails>): Mono<PaymentDetails> {
        return payment.flatMap { p ->
            val txn = generatedId()
            val date = LocalDate.now()
            val time = LocalTime.now()
            val updated = p.copy(transactionId = txn, paymentDate = date,
                paymentTime = time , paymentStatus = "Successfull")
            repo.insert(updated).thenReturn(updated)
        }
    }

    override fun viewAllPayments(): Flux<PaymentDetails> {
        return repo.findAll()
    }

    override fun viewById(id: String): Mono<PaymentDetails> {
        return repo.findById(id)
    }
}