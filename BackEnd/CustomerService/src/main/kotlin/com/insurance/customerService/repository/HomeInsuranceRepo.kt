package com.insurance.customerService.repository

import com.insurance.customerService.model.HomeInsurance
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Repository
interface HomeInsuranceRepo : ReactiveMongoRepository<HomeInsurance, String> {
    fun findByEmail(email: String): Flux<HomeInsurance>
}