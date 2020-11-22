package me.sangoh.clone.toss.spring_server_toss_clone.global.security.dto

import me.sangoh.clone.toss.spring_server_toss_clone.domain.model.Gender
import me.sangoh.clone.toss.spring_server_toss_clone.domain.model.Name
import me.sangoh.clone.toss.spring_server_toss_clone.domain.model.PhoneNumber
import java.time.LocalDate

data class SignupDto(
    val name: Name,
    val phoneNumber: PhoneNumber,
    val birthday: LocalDate,
    val gender: Gender,
    val termsCustomizedService: Boolean,
    val termsMarketingInformation: Boolean
) {}
