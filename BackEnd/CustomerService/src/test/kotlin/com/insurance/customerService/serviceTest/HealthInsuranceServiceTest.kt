package com.insurance.customerService.serviceTest

import com.insurance.customerService.model.HealthInsurance
import com.insurance.customerService.model.PolicyDetails
import com.insurance.customerService.repository.HealthInsuranceRepo
import com.insurance.customerService.serviceImpl.HealthInsuranceServiceImpl
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import reactor.test.StepVerifier
import java.time.LocalDate

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class HealthInsuranceServiceTest(
    @Autowired private var service : HealthInsuranceServiceImpl,
    @Autowired private var repo : HealthInsuranceRepo
) {

    val policy = PolicyDetails("","HAISIL001","Health Insurance",
        "Active",1,LocalDate.parse("2023-04-15"),LocalDate.parse("2024-04-14"),500000,
        8481,599)

    val customer = HealthInsurance("","xyz@abc.com","Raj","Kumar",
        "7894561234",35,"Male","Apni Gali","Rampura","M.P.",
        428200,175,80,true,"diabetes",
        2019,policy)
    val custMono = Mono.just(customer)

    @BeforeEach
    fun set(){
        repo = Mockito.mock(HealthInsuranceRepo::class.java)
        service = HealthInsuranceServiceImpl(repo)
    }

    @Test
    fun shouldSaveHealthInsuranceCustomer() {

        Mockito.`when`(repo.save(customer)).thenReturn(Mono.just(customer))

        StepVerifier.create(service.addUser(custMono))
            .expectSubscription()
            .expectNext(customer)
            .verifyComplete()
    }

    @Test
    fun getUsersByEmail(){

        Mockito.`when`(repo.findByEmail("xyz@abc.com")).thenReturn(Flux.just(customer))

        StepVerifier.create(service.getByEmail("xyz@abc.com"))
            .expectSubscription()
            .expectNext(customer)
            .verifyComplete()
    }

    @Test
    fun getUsersByPlanCode(){
        Mockito.`when`(repo.findByPolicyDetails_PlanCode("xyz@abc.com")).thenReturn(Flux.just(customer))

        StepVerifier.create(service.getByPlanCode("xyz@abc.com"))
            .expectSubscription()
            .expectNext(customer)
            .verifyComplete()
    }
}