package com.insurance.policyService.controller

import com.insurance.policyService.model.HealthInsurancePolicy
import com.insurance.policyService.model.HomeInsurancePolicy
import com.insurance.policyService.service.HealthInsuranceService
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/maxinsure/policies/healthinsurance")
@CrossOrigin("http://localhost:3000")
class HealthInsuranceController (
    private val service : HealthInsuranceService
) {

    @GetMapping()
    fun getAllPolicies(): Flux<HealthInsurancePolicy> {
        return service.getPolicies()
    }

    @PostMapping()
    fun addPolicy(@RequestBody policy : Mono<HealthInsurancePolicy>) : Mono<HealthInsurancePolicy> {
        return service.addPolicy(policy).log()
    }

    @DeleteMapping("/delete/{id}")
    fun deletePolicy(@PathVariable id : String) : Mono<Void> {
        return service.deleteById(id)
    }

    @GetMapping("/ById/{id}")
    fun getPolicyById(@PathVariable id : String) : Mono<HealthInsurancePolicy> {
        return service.getById(id)
    }

    @GetMapping("/checks")
    fun getByChecks(
        @RequestParam illness : Boolean , @RequestParam duration : Int ,
        @RequestParam cover : Int, @RequestParam age : Int
        ) : Flux<HealthInsurancePolicy> {
        return service.getByChecks(illness , duration , cover , age)
    }

}