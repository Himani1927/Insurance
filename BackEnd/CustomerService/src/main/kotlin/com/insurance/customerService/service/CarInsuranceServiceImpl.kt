package com.insurance.customerService.service

import com.insurance.customerService.model.CarInsurance
import com.insurance.customerService.repository.CarInsuranceRepo
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class CarInsuranceServiceImpl(
    private val repo : CarInsuranceRepo
) : CarInsuranceService {

    override fun getAllCarInsuranceUser(): Flux<CarInsurance> {
        return repo.findAll()
    }

    override fun addCarInsuranceUser(user: Mono<CarInsurance>): Mono<CarInsurance> {
        return user.flatMap { repo.save(it) }
    }

    override fun deleteCarInsuranceUser(id: String): Mono<Void> {
        return repo.deleteById(id)
    }


}