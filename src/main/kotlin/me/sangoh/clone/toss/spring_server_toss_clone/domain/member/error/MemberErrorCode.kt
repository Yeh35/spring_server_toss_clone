package me.sangoh.clone.toss.spring_server_toss_clone.domain.member.error

import me.sangoh.clone.toss.spring_server_toss_clone.global.error.ErrorCode
import org.springframework.http.HttpStatus

enum class MemberErrorCode(
    private val status: HttpStatus,
    private val code: String,
    private val messageEn: String,
    private val messageKo: String
) : ErrorCode {
    ABNORMAL_DEVICE(
        HttpStatus.FORBIDDEN,
        "MEMBER01",
        "Access to the device in which the abnormality was detected is prohibited.",
        "이상이 감지된 디바이스로 접근이 금지되었습니다."
    ),
    NOT_LOGIN(
        HttpStatus.OK,
        "MEMBER02",
        "not login",
        "로그인하지 않음"
    ),
    NOT_WAKEUP_TOO_LONG(
    HttpStatus.OK,
    "MEMBER02",
    "Not running for a long time",
    "오랜시간동안 실행하지 않음"
    )

    ;

    override fun getStatus(): HttpStatus {
        return status
    }

    override fun getCode(): String {
        return code
    }

    override fun getMessageEn(): String {
        return messageEn
    }

    override fun getMessageKo(): String {
        return messageKo
    }
}