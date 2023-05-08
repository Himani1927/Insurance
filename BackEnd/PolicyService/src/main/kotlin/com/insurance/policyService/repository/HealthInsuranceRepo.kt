package com.insurance.policyService.repository

import com.insurance.policyService.model.HealthInsurancePolicy
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository

@Repository
interface HealthInsuranceRepo : ReactiveMongoRepository<HealthInsurancePolicy , String>