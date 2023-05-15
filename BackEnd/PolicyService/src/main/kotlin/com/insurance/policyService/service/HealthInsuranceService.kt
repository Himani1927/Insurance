package com.insurance.policyService.service

import com.insurance.policyService.model.HealthInsurancePolicy
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface HealthInsuranceService {

    fun addPolicy( policy : Mono<HealthInsurancePolicy>) : Mono<HealthInsurancePolicy>
    fun getPolicies() : Flux<HealthInsurancePolicy>
    fun getById( id : String ) : Mono<HealthInsurancePolicy>
    fun deleteById( id : String) : Mono<Void>
    fun getByChecks( previousIllness : Boolean , duration : Int, cover : Int , age : Int) : Flux<HealthInsurancePolicy>

}