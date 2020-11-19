package me.sangoh.clone.toss.spring_server_toss_clone.domain.model

import javax.persistence.Column
import javax.persistence.Embeddable
import javax.validation.constraints.NotEmpty

@Embeddable
class Address private constructor(
    @Column(name = "county")
    val county: @NotEmpty String,

    @Column(name = "state")
    val state: @NotEmpty String,

    @Column(name = "city")
    val city: @NotEmpty String,

    @Column(name = "zip_code")
    val zipCode: @NotEmpty String
) {

    fun getFullAddress(): String {
        return String.format("%s %s %s", this.state, this.city, this.zipCode)
    }
}