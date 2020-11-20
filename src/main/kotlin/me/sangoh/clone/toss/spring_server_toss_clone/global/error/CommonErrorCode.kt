package me.sangoh.clone.toss.spring_server_toss_clone.global.error

import org.springframework.http.HttpStatus

enum class CommonErrorCode(
    private val status: HttpStatus,
    private val code: String,
    private val messageKo: String,
    private val messageEn: String
): ErrorCode {

    INVALID_INPUT_VALUE(HttpStatus.BAD_REQUEST, "C001", "Invalid Input Value", "잘못된 입력 값"),
    METHOD_NOT_ALLOWED(HttpStatus.METHOD_NOT_ALLOWED, "C002", "Invalid Input Value", "잘못된 입력 값"),
    ENTITY_NOT_FOUND(HttpStatus.BAD_REQUEST, "C003", " Entity Not Found", "엔티티를 찾을 수 없음"),
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR , "C004", "Server Error", "서버 오류"),
    INVALID_TYPE_VALUE(HttpStatus.BAD_REQUEST, "C005", " Invalid Type Value", "잘못된 유형 값"),
    HANDLE_ACCESS_DENIED(HttpStatus.FORBIDDEN, "C006", "Access is Denied", "접근이 금지되어있다"),
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