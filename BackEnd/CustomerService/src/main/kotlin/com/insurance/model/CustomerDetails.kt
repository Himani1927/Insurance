package com.insurance.model

import lombok.Getter
import lombok.NoArgsConstructor
import lombok.Setter
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.OneToMany

@NoArgsConstructor
@Getter
@Setter
@Entity
class CustomerDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var customerId:Int = 0
    var customerName:String = ""
    var customerEmail:String = ""
    var contactNumber:String = ""

    @OneToMany(mappedBy = "customerDetails")
    var vehicles: List<CustomerCarDetails>? = null
}