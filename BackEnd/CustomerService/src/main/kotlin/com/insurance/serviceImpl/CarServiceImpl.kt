package com.insurance.serviceImpl

import com.insurance.repository.CarDetailsRepo
import com.insurance.service.CarService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CarServiceImpl(private val carDetailsRepo: CarDetailsRepo) : CarService {

    override fun viewAllBrands(): List<String> {
        return carDetailsRepo.findAllDistinctBrands()
    }
}