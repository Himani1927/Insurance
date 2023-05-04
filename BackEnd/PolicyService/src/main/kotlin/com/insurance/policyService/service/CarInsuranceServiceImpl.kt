package com.insurance.policyService.service

import com.insurance.policyService.model.CarDetails
import com.insurance.policyService.repository.CarDetailsRepo
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class CarInsuranceServiceImpl(
    private val carRepo : CarDetailsRepo
) : CarInsuranceService {
    override fun addCar(carDetails: Mono<CarDetails>): Mono<CarDetails> {
        return carDetails.flatMap { carRepo.insert(it) }
    }

    override fun getAllCars(): Flux<CarDetails> {
        return carRepo.findAll()
    }

    override fun getBrandsList(): Flux<Map<String, Any>> {
        return carRepo.getAllCarBrands()
    }

//    override fun getCarsByBrand(brand: String): Flux<String> {
//        return carRepo.getCarByBrand(brand)
//    }

    override fun getVariantsByNameAndFuelType(modelName: String, fuelType: String): Flux<String> {
        TODO("Not yet implemented")
    }
}