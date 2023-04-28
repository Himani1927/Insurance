package com.insurance.repository

import com.insurance.model.CustomerCarDetails
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CustomerCarRepo : JpaRepository<CustomerCarDetails, String> {
}