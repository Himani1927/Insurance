package com.insurance.model

import lombok.Getter
import lombok.NoArgsConstructor
import lombok.Setter
import lombok.ToString
import javax.persistence.*

@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class CarDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var carId:Int = 0
    var carType:String = ""
    var brand:String = ""
    var model:String = ""
    var fuelType:String = ""
    var variant:String = ""
    var engine:String = ""

    @OneToMany(mappedBy = "carDetails")
    var customerCarDetails: List<CustomerCarDetails>? = null

}