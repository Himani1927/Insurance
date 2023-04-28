package com.insurance.model

import lombok.Getter
import lombok.NoArgsConstructor
import lombok.Setter
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne

@NoArgsConstructor
@Getter
@Setter
@Entity
class CustomerCarDetails {

    @Id
    var regNumber: String = ""
    var ownerName: String = ""
    var purchaseYear: Int = 0

    @ManyToOne
    @JoinColumn(name = "customerId")
    private var customerDetails : CustomerDetails? = null

    @ManyToOne
    @JoinColumn(name = "carId")
    private var carDetails:CarDetails? = null

}