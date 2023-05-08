package com.insurance.policyService.repository

import com.insurance.policyService.model.HomeInsurancePolicy
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Repository
interface HomeInsuranceRepo : ReactiveMongoRepository<HomeInsurancePolicy,String> {

    fun findByPlanType(planType: String): Flux<HomeInsurancePolicy>

}