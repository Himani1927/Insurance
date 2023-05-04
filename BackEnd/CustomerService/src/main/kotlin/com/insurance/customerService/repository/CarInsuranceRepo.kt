package com.insurance.customerService.repository

import com.insurance.customerService.model.CarInsurance
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository

@Repository
interface CarInsuranceRepo : ReactiveMongoRepository<CarInsurance,String>