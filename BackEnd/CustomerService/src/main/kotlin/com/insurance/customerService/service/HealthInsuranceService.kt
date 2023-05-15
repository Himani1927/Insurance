package com.insurance.customerService.service

import com.insurance.customerService.model.HealthInsurance
import com.insurance.customerService.model.HomeInsurance
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface HealthInsuranceService {

    fun getAllUsers() : Flux<HealthInsurance>
    fun addUser(user : Mono<HealthInsurance>) : Mono<HealthInsurance>
//    fun deleteUser( id : String) : Mono<Void>
    fun getByEmail(email: String): Flux<HealthInsurance>
    fun getByPlanCode(planCode : String) : Flux<HealthInsurance>

}