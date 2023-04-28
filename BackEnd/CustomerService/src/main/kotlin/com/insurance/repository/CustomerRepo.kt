package com.insurance.repository

import com.insurance.model.CustomerDetails
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CustomerRepo : JpaRepository<CustomerDetails, Int> {
}