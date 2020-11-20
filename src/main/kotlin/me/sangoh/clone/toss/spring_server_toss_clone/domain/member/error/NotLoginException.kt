package me.sangoh.clone.toss.spring_server_toss_clone.domain.member.error

import me.sangoh.clone.toss.spring_server_toss_clone.domain.member.domain.Device
import me.sangoh.clone.toss.spring_server_toss_clone.global.error.ErrorCode
import me.sangoh.clone.toss.spring_server_toss_clone.global.error.exception.InvalidValueException
import me.sangoh.clone.toss.spring_server_toss_clone.global.utill.ULog

/**
 * 비 정상적인 디바이스로 접근하는 경우 차단
 */
class NotLoginException private constructor(value: String, errorCode: ErrorCode, vararg args: Any?) :
    InvalidValueException(value, errorCode, *args) {

    companion object: ULog {
        fun of(device: Device): NotLoginException {
            return NotLoginException(
                value = "비정상적인 디바이스(id: ${device.id})로 접근하는 경우 차단하였습니다.",
                errorCode = MemberErrorCode.ABNORMAL_DEVICE
            )
        }
    }
}
