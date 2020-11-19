package me.sangoh.clone.toss.spring_server_toss_clone.domain.model

import javax.persistence.Column
import javax.persistence.Embeddable
import javax.validation.constraints.NotEmpty

@Embeddable
class Email private constructor(
    @javax.validation.constraints.Email
    @NotEmpty
    @Column(name = "email", length = 50)
    private val value: String
) {

    companion object {
        fun of(value: String): Email {
            return Email(value)
        }
    }

    fun getHost(): String? {
        val index = value.indexOf("@")
        return if (index == -1) null else value.substring(index + 1)
    }

    fun getId(): String? {
        val index = value.indexOf("@")
        return if (index == -1) null else value.substring(0, index)
    }
}