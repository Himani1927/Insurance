package com.insurance.customerService.service

import com.insurance.customerService.model.HomeInsurance
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface HomeInsuranceService {

//    fun getAllUsers() : Flux<HomeInsurance>
    fun addUser(user : Mono<HomeInsurance>) : Mono<HomeInsurance>
//    fun deleteUser( id : String) : Mono<Void>
    fun getByEmail(email: String): Flux<HomeInsurance>

}