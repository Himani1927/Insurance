package com.insurance.policyService.service

import com.insurance.policyService.model.CarDetails
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface CarInsuranceService {

    fun addCar(carDetails: Mono<CarDetails>) : Mono<CarDetails>
    fun getAllCars() : Flux<CarDetails>

    fun getBrandsList() : Flux<Map<String, Any>>
//    fun getCarsByBrand(brand : String) : Flux<String>
    fun getVariantsByNameAndFuelType(modelName: String,fuelType: String): Flux<String>

}