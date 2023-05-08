package com.insurance.customerService.repository

import com.insurance.customerService.model.PolicyDetails
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository

@Repository
interface PolicyDetailsRepo : ReactiveMongoRepository<PolicyDetails , String>{
}