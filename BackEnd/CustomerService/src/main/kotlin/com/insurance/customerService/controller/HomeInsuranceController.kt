package com.insurance.customerService.controller

import com.insurance.customerService.model.HomeInsurance
import com.insurance.customerService.service.HomeInsuranceService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/maxinsure/homeinsurance")
class HomeInsuranceController(
    private val service : HomeInsuranceService
) {

    @PostMapping("/user/add")
    fun addUser(@RequestBody user : Mono<HomeInsurance>) : Mono<HomeInsurance> =service.addUser(user).log()

    @GetMapping("/user/{email}")
    fun getUserByEmail(@PathVariable email : String ) : Flux<HomeInsurance> = service.getByEmail(email)

}