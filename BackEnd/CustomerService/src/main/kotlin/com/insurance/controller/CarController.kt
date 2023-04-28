package com.insurance.controller

import com.insurance.service.CarService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/insurance/carinsurance")
class CarController(private val carService: CarService) {

    @GetMapping("/allBrands")
    fun getAllBrands() : ResponseEntity<List<String>>  {
        return ResponseEntity.ok(carService.viewAllBrands())
    }

}