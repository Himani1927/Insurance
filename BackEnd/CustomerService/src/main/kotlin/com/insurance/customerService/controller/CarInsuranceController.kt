package com.insurance.customerService.controller

import com.insurance.customerService.model.CarInsurance
import com.insurance.customerService.service.CarInsuranceService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/maxInsure")
class CarInsuranceController(
    private val service : CarInsuranceService
) {

    @GetMapping("/carInsurance")
    fun getAllUser() : Flux<CarInsurance>{
        return service.getAllCarInsuranceUser()
    }

    @PostMapping("/carInsurance")
    fun addUser(user : Mono<CarInsurance>) :Mono<CarInsurance> {
        return service.addCarInsuranceUser(user)
    }

    fun deleteUser(id : String) : Mono<Void> {
        return service.deleteCarInsuranceUser(id)
    }

}