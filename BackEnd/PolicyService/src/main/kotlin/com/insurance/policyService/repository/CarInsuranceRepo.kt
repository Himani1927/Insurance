package com.insurance.policyService.repository

import com.insurance.policyService.model.CarInsurancePolicy
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository

@Repository
interface CarInsuranceRepo : ReactiveMongoRepository<CarInsurancePolicy, String>