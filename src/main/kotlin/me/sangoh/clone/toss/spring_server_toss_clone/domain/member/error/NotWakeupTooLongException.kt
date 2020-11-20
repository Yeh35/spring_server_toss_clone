package me.sangoh.clone.toss.spring_server_toss_clone.domain.member.error

import me.sangoh.clone.toss.spring_server_toss_clone.domain.member.domain.Device
import me.sangoh.clone.toss.spring_server_toss_clone.global.error.ErrorCode
import me.sangoh.clone.toss.spring_server_toss_clone.global.error.exception.InvalidValueException
import me.sangoh.clone.toss.spring_server_toss_clone.global.utill.ULog

class NotWakeupTooLongException private constructor(value: String, errorCode: ErrorCode, vararg args: Any?) :
    InvalidValueException(value, errorCode, *args) {

    companion object : ULog {
        fun of(device: Device): NotWakeupTooLongException {
            return NotWakeupTooLongException(
                value = "너무 오랜 시간동안 실행하지 않음 (device Id: ${device.id})",
                errorCode = MemberErrorCode.NOT_WAKEUP_TOO_LONG
            )
        }
    }
}
