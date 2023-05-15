package com.insurance.paymentService.repository

import com.insurance.paymentService.model.PaymentDetails
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository

@Repository
interface PaymentRepo : ReactiveMongoRepository<PaymentDetails , String>