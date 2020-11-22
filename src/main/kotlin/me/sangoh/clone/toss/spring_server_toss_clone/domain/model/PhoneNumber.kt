package me.sangoh.clone.toss.spring_server_toss_clone.domain.model

import javax.persistence.Column
import javax.persistence.Embeddable
import javax.validation.constraints.NotEmpty

@Embeddable
class PhoneNumber(
    @NotEmpty
    @Column(name = "first_number", length = 50)
    val first: String,

    @NotEmpty
    @Column(name = "middle_number", length = 50)
    val middle: String,

    @NotEmpty
    @Column(name = "last_number", length = 50)
    val last: String
) {

    fun getNumber(): String {
        return first + middle + last
    }
}