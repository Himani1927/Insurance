package com.insurance.customerService.service

import com.insurance.customerService.model.CarInsurance
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface CarInsuranceService {

    fun getAllCarInsuranceUser() : Flux<CarInsurance>
    fun addCarInsuranceUser(user : Mono<CarInsurance>) : Mono<CarInsurance>
    fun deleteCarInsuranceUser(id : String) : Mono<Void>

}