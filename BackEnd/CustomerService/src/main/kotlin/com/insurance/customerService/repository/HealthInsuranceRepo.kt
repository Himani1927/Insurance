package com.insurance.customerService.repository

import com.insurance.customerService.model.HealthInsurance
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Repository
interface HealthInsuranceRepo : ReactiveMongoRepository<HealthInsurance, String> {
    fun findByEmail(email: String): Flux<HealthInsurance>
    fun findByPolicyDetails_PlanCode(planCode: String): Flux<HealthInsurance>
}