package com.insurance.customerService.controller

import com.insurance.customerService.model.HealthInsurance
import com.insurance.customerService.model.HomeInsurance
import com.insurance.customerService.service.HealthInsuranceService
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/maxinsure/healthinsurance")
class HealthInsuranceController(
    private val service: HealthInsuranceService
) {

    @PostMapping("/user/add")
    fun addUser(@RequestBody user : Mono<HealthInsurance>) : Mono<HealthInsurance> =service.addUser(user)

    @GetMapping("/user/all")
    fun getAllUser() : Flux<HealthInsurance> = service.getAllUsers()

    @GetMapping("/user/{email}")
    fun getUserByEmail(@PathVariable email : String ) : Flux<HealthInsurance> = service.getByEmail(email)

    @GetMapping("/user/{policyCode}")
    fun getByPolicyCode(@PathVariable policyCode : String) : Mono<HealthInsurance> = service.getByPolicyCode(policyCode)

}