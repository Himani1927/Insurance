package com.insurance.customerService.controller

import com.insurance.customerService.model.HealthInsurance
import com.insurance.customerService.model.HomeInsurance
import com.insurance.customerService.service.HealthInsuranceService
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/maxinsure/healthinsurance")
@CrossOrigin("http://localhost:3000")
class HealthInsuranceController(
    private val service: HealthInsuranceService
) {

    @PostMapping("/user/add")
    fun addUser(@RequestBody user : Mono<HealthInsurance>) : Mono<HealthInsurance> = service.addUser(user)

    @GetMapping("/user/all")
    fun getAllUser() : Flux<HealthInsurance> = service.getAllUsers()

    @GetMapping("/user/{email}")
    fun getUserByEmail(@PathVariable email : String ) : Flux<HealthInsurance> = service.getByEmail(email)

    @GetMapping("/user/{planCode}")
    fun getByPlanCode(@PathVariable planCode : String) : Flux<HealthInsurance> = service.getByPlanCode(planCode)

}