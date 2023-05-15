package com.insurance.policyService.service

import com.insurance.policyService.model.HomeInsurancePolicy
import com.insurance.policyService.repository.HomeInsuranceRepo
import com.insurance.policyService.serviceImpl.HomeInsuranceServiceImpl
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import reactor.test.StepVerifier

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class HomeInsuranceServiceTest(
    @Autowired private var service : HomeInsuranceServiceImpl,
    @Autowired private var repo : HomeInsuranceRepo
) {

    val policy = HomeInsurancePolicy("HIPLT003",
        "Platinum Plan For both Building & HouseHold Items",
        "BOTH",listOf("Feature 1", "Feature 2", "Feature 3"),17)
    val policyMono = Mono.just(policy)

    @BeforeEach
    fun set() {
        repo = Mockito.mock(HomeInsuranceRepo::class.java)
        service = HomeInsuranceServiceImpl(repo)
    }

    @Test
    fun addPolicy() {
        Mockito.`when`(repo.insert(policy)).thenReturn(Mono.just(policy))

        StepVerifier.create(service.addPolicy(policyMono))
            .expectSubscription()
            .expectNext(policy)
            .verifyComplete()
    }

    @Test
    fun getAllPolicy() {
        val policyList = listOf(policy)

        Mockito.`when`(repo.findAll()).thenReturn(Flux.fromIterable(policyList))

        StepVerifier.create(service.getPolicies())
            .expectSubscription()
            .expectNextSequence(policyList)
            .verifyComplete()
    }





}