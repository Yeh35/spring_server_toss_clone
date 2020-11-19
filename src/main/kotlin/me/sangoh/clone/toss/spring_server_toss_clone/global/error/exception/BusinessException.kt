package me.sangoh.clone.toss.spring_server_toss_clone.global.error.exception

import me.sangoh.clone.toss.spring_server_toss_clone.global.error.ErrorCode

/**
 * Business 로직과 관련된 Exception의 초상위 Exception이다.
 */
class BusinessException : RuntimeException {
    private var errorCode: ErrorCode

    constructor(message: String?, errorCode: ErrorCode) : super(message) {
        this.errorCode = errorCode
    }

    constructor(errorCode: ErrorCode) : super(errorCode.getMessage()) {
        this.errorCode = errorCode
    }

    fun getErrorCode(): ErrorCode {
        return errorCode
    }
}
