package com.insurance.policyService.controller

import com.insurance.policyService.service.PolicyService
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping
class PolicyController(
    private val service: PolicyService
) {
}