package me.sangoh.clone.toss.spring_server_toss_clone.domain.member.dto

import me.sangoh.clone.toss.spring_server_toss_clone.domain.member.domain.Device

data class DeviceSignupDto(
    val uuid: String,
    val password: String
) {

    fun toDevice(): Device {
        return Device(
            uuid = uuid,
            password = password
        )
    }
}
