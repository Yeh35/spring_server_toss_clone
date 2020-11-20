package me.sangoh.clone.toss.spring_server_toss_clone.global.error.exception

import me.sangoh.clone.toss.spring_server_toss_clone.global.error.CommonErrorCode
import me.sangoh.clone.toss.spring_server_toss_clone.global.error.ErrorCode

/**
 *  값 자체가 잘못된 경우 발생하는 Exception이다.
 */
class InvalidValueException : BusinessException {
    constructor(value: String?) : super(value, CommonErrorCode.INVALID_INPUT_VALUE)
    constructor(value: String?, errorCode: ErrorCode) : super(value, errorCode)
}
