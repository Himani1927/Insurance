package com.insurance.policyService.controller

import com.insurance.policyService.model.CarDetails
import com.insurance.policyService.service.CarInsuranceService
import com.insurance.policyService.service.CarInsuranceServiceImpl
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/maxInsure")
class CarInsuranceController(
    private val service: CarInsuranceService
) {

    @PostMapping("/cars")
    fun addCar(@RequestBody carDetails: Mono<CarDetails>):Mono<CarDetails> = service.addCar(carDetails)

    @GetMapping("/cars")
    fun getAllCars():Flux<CarDetails> = service.getAllCars()

    @GetMapping("/car/brands")
    fun getCarBrands() : Flux<Map<String, Any>> = service.getBrandsList()

}