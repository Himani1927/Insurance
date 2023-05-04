package com.insurance.policyService.service

import com.insurance.policyService.model.Policies
import com.insurance.policyService.repository.PoliciesRepo
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class PolicyServiceImpl(
    private val repo: PoliciesRepo
) : PolicyService
 {

    override fun getPolicies(): Flux<Policies> = repo.findAll()

    override fun getPoliciesByType(type: String): Flux<Policies> = repo.findPolicyByType(type)

    override fun addPolicy(policy: Mono<Policies>): Mono<Policies> = policy.flatMap { repo.insert(it) }

    override fun updatePolicyByCode(policy: Mono<Policies>, policyCode: String): Mono<Policies>{
        return repo.findById(policyCode)
            .flatMap { existingPolicy -> policy
                .map { newPolicy ->existingPolicy
                    .apply { existingPolicy.policyType = newPolicy.policyType
                        existingPolicy.policyCover = newPolicy.policyCover
                        existingPolicy.policyDuration = newPolicy.policyDuration
                        existingPolicy.policyPremiumYearly = newPolicy.policyPremiumYearly
                        existingPolicy.policyPremiumMonthly = newPolicy.policyPremiumMonthly
                        existingPolicy.policyDescription = newPolicy.policyDescription
                        existingPolicy.policyFeatures=newPolicy.policyFeatures }
                }
            }
            .flatMap(repo::save)
    }

    override fun deletePolicyByCode(policyCode: String): Mono<Void> = repo.deleteById(policyCode)
}