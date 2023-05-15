package com.insurance.policyService.serviceImpl

import com.insurance.policyService.model.HealthInsurancePolicy
import com.insurance.policyService.repository.HealthInsuranceRepo
import com.insurance.policyService.service.HealthInsuranceService
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class HealthInsuranceServiceImpl(
    private val repo : HealthInsuranceRepo
) : HealthInsuranceService {

    override fun addPolicy(policy: Mono<HealthInsurancePolicy>): Mono<HealthInsurancePolicy> {
        return policy.flatMap { repo.insert(it) }
    }

    override fun getPolicies(): Flux<HealthInsurancePolicy> {
        return repo.findAll().map { p ->
            val basePrice = p.basePrice
            p.copy(totalCost = basePrice*12 , costWithGst = basePrice*12*118/100)
        }
    }

    override fun getById(id: String): Mono<HealthInsurancePolicy> {
        return repo.findById(id).map { p ->
            val basePrice = p.basePrice
            p.copy(totalCost = basePrice*12 , costWithGst = basePrice*12*118/100)
        }
    }

    override fun deleteById(id: String): Mono<Void> {
        return repo.deleteById(id)
    }

    override fun getByChecks(
        previousIllness: Boolean, duration: Int, cover: Int, age: Int
    ): Flux<HealthInsurancePolicy> {
        return repo.findByPlanCover(cover).map { p ->
            val basePrice = p.basePrice
            if((previousIllness && age<60)) {
                p.copy(basePrice = basePrice+200,
                    totalCost = (basePrice+200)*duration*12,
                    costWithGst = (basePrice+200)*duration*12*118/100)
            }else if(age<60 && !previousIllness ){
                p.copy(totalCost = basePrice*duration*12,
                    costWithGst = basePrice*duration*12*118/100)
            }else if(age>60 && previousIllness){
                p.copy(basePrice = basePrice+200,
                    totalCost = (basePrice+200)*duration*12,
                    costWithGst = (basePrice+200)*duration*12*105/100)
            }else{
                p.copy(totalCost = basePrice*duration*12,
                    costWithGst = basePrice*duration*12*105/100)
            }
        }
    }
}