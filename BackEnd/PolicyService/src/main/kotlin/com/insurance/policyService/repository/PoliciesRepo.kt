package com.insurance.policyService.repository

import com.insurance.policyService.model.Policies
import org.springframework.data.mongodb.repository.Query
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux

@Repository
interface PoliciesRepo : ReactiveMongoRepository<Policies , String> {

    @Query("{'policyType': ?0}")
    fun findPolicyByType(type: String): Flux<Policies>
}