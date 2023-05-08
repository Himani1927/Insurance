package com.insurance.policyService.serviceImpl

import com.insurance.policyService.model.CarDetails
import com.insurance.policyService.model.CarInsurancePolicy
import com.insurance.policyService.repository.CarDetailsRepo
import com.insurance.policyService.repository.CarInsuranceRepo
import com.insurance.policyService.service.CarInsuranceService
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.util.Random

@Service
class CarInsuranceServiceImpl(
    private val carRepo : CarDetailsRepo,
    private val policyRepo : CarInsuranceRepo
) : CarInsuranceService {

    override fun addPolicy(policy: Mono<CarInsurancePolicy>): Mono<CarInsurancePolicy> {
        println("Check")
        return policy
            .log()
            .flatMap { policyRepo.save(it) }
    }

    override fun getAllPolicies(): Flux<CarInsurancePolicy> {
        return policyRepo.findAll()
    }

    override fun deletePolicyById(policyCode: String): Mono<Void> {
        return policyRepo.deleteById(policyCode)
    }

    override fun addCar(carDetails: Mono<CarDetails>): Mono<CarDetails> {
        return carDetails
            .map { carDetails-> carDetails.copy(carId = generatedCarId()) }
            .flatMap { carRepo.insert(it) }.log()
    }

    private fun generatedCarId(): Int {
        var carId : Int
        do {
            carId = Random().nextInt(100)
        }while (carRepo.findById(carId)!=null)
        return carId
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