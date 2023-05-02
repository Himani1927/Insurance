package com.insurance.policyService.service

import com.insurance.policyService.model.Policies
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface PolicyService {

    fun getPolicies() : Flux<Policies>
    fun getPoliciesByType(type : String) : Flux<Policies>
    fun addPolicy(policy : Mono<Policies>) : Mono<Policies>
    fun updatePolicyByCode(policy : Mono<Policies> , policyCode : String) : Mono<Policies>
    fun deletePolicyByCode(policyCode: String) : Mono<Void>

}