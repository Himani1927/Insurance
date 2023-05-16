package com.insurance.customerService.controller

import com.insurance.customerService.model.HomeInsurance
import com.insurance.customerService.service.HomeInsuranceService
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/maxinsure/homeinsurance")
@CrossOrigin("http://localhost:3000")
class HomeInsuranceController(
    private val service : HomeInsuranceService
) {
    @PostMapping("/user/add")
    fun addUser(@RequestBody user : Mono<HomeInsurance>) : Mono<HomeInsurance> =service.addUser(user).log()

    @GetMapping("/user/{email}")
    fun getUserByEmail(@PathVariable email : String ) : Flux<HomeInsurance> = service.getByEmail(email)


}