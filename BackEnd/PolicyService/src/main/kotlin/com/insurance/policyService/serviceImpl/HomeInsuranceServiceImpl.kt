package com.insurance.policyService.serviceImpl

import com.insurance.policyService.model.HomeInsurancePolicy
import com.insurance.policyService.repository.HomeInsuranceRepo
import com.insurance.policyService.service.HomeInsuranceService
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class HomeInsuranceServiceImpl(
    private val repo : HomeInsuranceRepo
) : HomeInsuranceService{

    override fun addPolicy(policy: Mono<HomeInsurancePolicy>): Mono<HomeInsurancePolicy> {
        return policy.flatMap { repo.insert(it) }
    }

    override fun getPolicies(): Flux<HomeInsurancePolicy> {
        return repo.findAll()
    }

    override fun deletePolicyById(id: String): Mono<Void> {
        return repo.deleteById(id)
    }

    override fun getById(id: String): Mono<HomeInsurancePolicy> {
        return repo.findById(id)
    }

    override fun getByPlanType(planType: String): Flux<HomeInsurancePolicy> {
        return repo.findByPlanType(planType)
    }

    override fun getByPlanTypeAndCostAndDuration(planType: String, propertyCost: Int , duration : Int) : Flux<HomeInsurancePolicy> {
        val policies = repo.findByPlanType(planType)
        return policies.map { policy ->
            val basePrice = policy.basePrice
            val additionalCost = if (planType == "BUILDING" || planType == "BOTH") {
                ((propertyCost - 500000) / 50000)+1
            } else {
                ((propertyCost - 100000) / 50000)+1
            }
            policy.copy(basePrice = basePrice + additionalCost, totalPrice = (basePrice + additionalCost)*duration*12)
        }
    }

    override fun getByCostAndDuration(propertyCost: Int, duration: Int): Flux<HomeInsurancePolicy> {
        TODO("Not yet implemented")
    }
}