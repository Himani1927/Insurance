package com.insurance.customerService.serviceImpl

import com.insurance.customerService.model.HomeInsurance
import com.insurance.customerService.repository.HomeInsuranceRepo
import com.insurance.customerService.repository.PolicyDetailsRepo
import com.insurance.customerService.service.HomeInsuranceService
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import kotlin.random.Random

@Service
class HomeInsuranceServiceImpl(
    private val repo : HomeInsuranceRepo,
    private val policyRepo : PolicyDetailsRepo
) : HomeInsuranceService{

    override fun getAllUsers(): Flux<HomeInsurance> {
        return repo.findAll()
    }

    override fun addUser(user: Mono<HomeInsurance>): Mono<HomeInsurance> {
        return user.flatMap { u ->
            val code = generateCode()
            u.policyDetails = u.policyDetails.copy(policyCode = code)
            repo.save(u) }
    }

    private fun generateCode(): String {
        val currentDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"))
        val randomLetters = (1..2).map { Random.nextInt('A'.code, 'Z'.code + 1).toChar() }.joinToString("")
        val currentTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("mmss"))

        return "$currentDate$randomLetters$currentTime"
    }

    override fun deleteUser(id: String): Mono<Void> {
        return repo.deleteById(id)
    }

    override fun getByEmail(email: String): Flux<HomeInsurance> {
        return repo.findByEmail(email)
    }

}