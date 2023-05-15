package com.insurance.customerService.serviceTest

import com.insurance.customerService.model.HomeInsurance
import com.insurance.customerService.model.PolicyDetails
import com.insurance.customerService.repository.HealthInsuranceRepo
import com.insurance.customerService.repository.HomeInsuranceRepo
import com.insurance.customerService.serviceImpl.HealthInsuranceServiceImpl
import com.insurance.customerService.serviceImpl.HomeInsuranceServiceImpl
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import reactor.test.StepVerifier
import java.time.LocalDate

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class HomeInsuranceServiceTest(
    @Autowired private var service : HomeInsuranceServiceImpl,
    @Autowired private var repo : HomeInsuranceRepo
) {

    val policy = PolicyDetails("","HISIL001","Home Insurance",
        "Active",1, LocalDate.parse("2023-04-15"), LocalDate.parse("2024-04-14"),500000,
        144,12)

    val customer = HomeInsurance("","xyz@abc.com","Raj","Kumar",
        "7894561234","Meri Gali","Mera Shehar","420840",
        "Delhi",true,"","","",
        "","Apartment","Owner",true,800000,
        false,0,policy)
    val custMono = Mono.just(customer)

    @BeforeEach
    fun set(){
        repo = Mockito.mock(HomeInsuranceRepo::class.java)
        service = HomeInsuranceServiceImpl(repo)
    }

    @Test
    fun shouldSaveHomeInsuranceCustomer() {
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
}