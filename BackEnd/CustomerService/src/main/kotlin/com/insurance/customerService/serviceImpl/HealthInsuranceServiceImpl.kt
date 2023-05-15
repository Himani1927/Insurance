package com.insurance.customerService.serviceImpl

import com.insurance.customerService.model.HealthInsurance
import com.insurance.customerService.repository.HealthInsuranceRepo
import com.insurance.customerService.service.HealthInsuranceService
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import kotlin.random.Random

@Service
class HealthInsuranceServiceImpl(
    private val repo : HealthInsuranceRepo
) : HealthInsuranceService {

    override fun getAllUsers(): Flux<HealthInsurance> {
        return repo.findAll()
    }

    override fun addUser(user: Mono<HealthInsurance>): Mono<HealthInsurance> {
        return user.flatMap { u ->
            val code = generateCode()
            val startDate = LocalDate.now()
            val endDate = startDate.plusYears(u.policyDetails.durationInYears.toLong())
            u.policyDetails = u.policyDetails.copy(policyCode = code,
                startDate = startDate,
                endDate = endDate,
                policyStatus = "Active")
            repo.save(u) }
    }

    private fun generateCode(): String {
        val currentDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"))
        val randomLetters = (1..2).map { Random.nextInt('A'.code, 'Z'.code + 1).toChar() }.joinToString("")
        val currentTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("mmss"))

        return "HL$currentDate$randomLetters$currentTime"
    }

//    override fun deleteUser(id: String): Mono<Void> {
//        return repo.deleteById(id)
//    }

    override fun getByEmail(email: String): Flux<HealthInsurance> {
        return repo.findByEmail(email)
    }

    override fun getByPlanCode(planCode: String): Flux<HealthInsurance> {
        return repo.findByPolicyDetails_PlanCode(planCode)
    }


}