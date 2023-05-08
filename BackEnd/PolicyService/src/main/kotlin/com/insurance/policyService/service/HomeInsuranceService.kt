package com.insurance.policyService.service

import com.insurance.policyService.model.HomeInsurancePolicy
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface HomeInsuranceService {

    fun addPolicy(policy : Mono<HomeInsurancePolicy>) : Mono<HomeInsurancePolicy>
    fun getPolicies() : Flux<HomeInsurancePolicy>
    fun deletePolicyById(id : String) : Mono<Void>
    fun getById(id : String) : Mono<HomeInsurancePolicy>
    fun getByPlanType(planType : String) : Flux<HomeInsurancePolicy>
    fun getByPlanTypeAndCostAndDuration(planType: String , propertyCost : Int , duration : Int) : Flux<HomeInsurancePolicy>

}