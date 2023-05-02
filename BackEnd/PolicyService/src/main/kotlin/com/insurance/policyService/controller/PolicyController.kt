package com.insurance.policyService.controller

import com.insurance.policyService.model.Policies
import com.insurance.policyService.service.PolicyService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/maxinsure")
class PolicyController(
    private val service: PolicyService
) {

    @GetMapping("/policies/all")
    fun getPolicies() : Flux<Policies> = service.getPolicies()

    @GetMapping("/policies/{type}")
    fun getPoliciesByType(@PathVariable type : String) : Flux<Policies> = service.getPoliciesByType(type)

    @PostMapping("/policies/add")
    fun addPolicy(@RequestBody policy : Mono<Policies>) : Mono<Policies> = service.addPolicy(policy)

    @PutMapping("/policies/update/{policyCode}")
    fun updatePolicy(@RequestBody policy: Mono<Policies>, @PathVariable policyCode : String) : Mono<Policies> {
        return service.updatePolicyByCode(policy,policyCode)
    }

    @DeleteMapping("/policies/delete/{policyCode}")
    fun deletePolicy(@PathVariable policyCode: String) : Mono<Void> = service.deletePolicyByCode(policyCode)

}