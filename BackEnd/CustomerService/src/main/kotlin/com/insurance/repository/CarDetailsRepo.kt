package com.insurance.repository

import com.insurance.model.CarDetails
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface CarDetailsRepo: JpaRepository<CarDetails, Int> {

    @Query("SELECT DISTINCT c.brand FROM CarDetails c")
    fun findAllDistinctBrands(): List<String>
}