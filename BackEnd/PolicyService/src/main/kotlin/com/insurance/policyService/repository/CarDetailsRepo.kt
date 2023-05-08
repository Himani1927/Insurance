package com.insurance.policyService.repository

import com.insurance.policyService.model.CarDetails
import org.springframework.data.mongodb.repository.Aggregation
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux

@Repository
interface CarDetailsRepo : ReactiveMongoRepository<CarDetails , Int> {

    @Aggregation("{ \$group: { _id: '\$carBrand' } }")
    fun getAllCarBrands(): Flux<Map<String, Any>>

//    @Aggregation()
//    fun getCarsByBrand(brand: String): Flux<String>


}