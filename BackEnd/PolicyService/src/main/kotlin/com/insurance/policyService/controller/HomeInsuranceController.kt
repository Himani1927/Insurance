package com.insurance.policyService.controller

import com.insurance.policyService.model.HomeInsurancePolicy
import com.insurance.policyService.service.HomeInsuranceService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/maxinsure/policies/homeinsurance")
class HomeInsuranceController(
    private val service: HomeInsuranceService
) {

    @GetMapping()
    fun getAllPolicies():Flux<HomeInsurancePolicy>{
        return service.getPolicies()
    }

    @PostMapping()
    fun addPolicy(@RequestBody policy : Mono<HomeInsurancePolicy>) : Mono<HomeInsurancePolicy> {
        return service.addPolicy(policy)
    }

    @DeleteMapping("/{id}")
    fun deletePolicy(@PathVariable id : String) : Mono<Void> {
        return service.deletePolicyById(id)
    }

    @GetMapping("/ById/{id}")
    fun getPolicyById(@PathVariable id : String) : Mono<HomeInsurancePolicy> {
        return service.getById(id)
    }

    @GetMapping("/ByType/{planType}")
    fun getPolicyByType(@PathVariable planType : String) : Flux<HomeInsurancePolicy> {
        return service.getByPlanType(planType)
    }

    @GetMapping("/ByType/{planType}/property-cost")
    fun getPolicyByTypeCostDuration(@PathVariable planType : String , @RequestParam cost : Int , @RequestParam duration : Int) : Flux<HomeInsurancePolicy> {
        return service.getByPlanTypeAndCostAndDuration(planType,cost,duration)
    }

}