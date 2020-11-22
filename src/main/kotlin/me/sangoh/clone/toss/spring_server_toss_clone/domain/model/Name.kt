package me.sangoh.clone.toss.spring_server_toss_clone.domain.model

import javax.persistence.Column
import javax.persistence.Embeddable
import javax.validation.constraints.NotEmpty

@Embeddable
class Name(
    @NotEmpty
    @Column(name = "first_name", length = 50)
    val first: String,

    @Column(name = "middle_name", length = 50)
    val middle: String = "",

    @NotEmpty
    @Column(name = "last_name", length = 50)
    val last: String
) {

    fun getFullName(): String? {
        return if (middle == "") {
            String.format("%s %s", first, last)
        } else {
            String.format("%s %s %s", first, middle, last)
        }
    }

}