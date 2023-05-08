package com.insurance.policyService.service

import com.insurance.policyService.model.CarDetails
import com.insurance.policyService.model.CarInsurancePolicy
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface CarInsuranceService {

    //Policies
    fun addPolicy(policy : Mono<CarInsurancePolicy>) : Mono<CarInsurancePolicy>
    fun getAllPolicies() : Flux<CarInsurancePolicy>
    fun deletePolicyById(policyCode : String) : Mono<Void>



    fun addCar(carDetails: Mono<CarDetails>) : Mono<CarDetails>
    fun getAllCars() : Flux<CarDetails>

    fun getBrandsList() : Flux<Map<String, Any>>
//    fun getCarsByBrand(brand : String) : Flux<String>
    fun getVariantsByNameAndFuelType(modelName: String,fuelType: String): Flux<String>

}