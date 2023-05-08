package com.insurance.policyService.controller

import com.insurance.policyService.model.CarDetails
import com.insurance.policyService.model.CarInsurancePolicy
import com.insurance.policyService.service.CarInsuranceService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/maxInsure/CarInsurance")
class CarInsuranceController(
    private val service: CarInsuranceService
) {

    @GetMapping("/policy")
    fun getAllPolicies() : Flux<CarInsurancePolicy> = service.getAllPolicies()

    @PostMapping("/policy")
    fun addPolicy(@RequestBody  policy : Mono<CarInsurancePolicy>) = service.addPolicy(policy)

    @DeleteMapping("/policy/{policyCode}")
    fun deletePolicy(@PathVariable policyCode : String) : Mono<Void> = service.deletePolicyById(policyCode)

    @PostMapping("/cars")
    fun addCar(@RequestBody carDetails: Mono<CarDetails>):Mono<CarDetails> = service.addCar(carDetails)

    @GetMapping("/cars")
    fun getAllCars():Flux<CarDetails> = service.getAllCars()

    @GetMapping("/car/brands")
    fun getCarBrands() : Flux<Map<String, Any>> = service.getBrandsList()

}