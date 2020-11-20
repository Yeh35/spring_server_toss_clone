package me.sangoh.clone.toss.spring_server_toss_clone.global.error.exception

import me.sangoh.clone.toss.spring_server_toss_clone.global.error.CommonErrorCode
import me.sangoh.clone.toss.spring_server_toss_clone.global.error.ErrorCode

/**
 *  값 자체가 잘못된 경우 발생하는 Exception이다.
 */
abstract class InvalidValueException : BusinessException {
    protected constructor(value: String) : super(value, CommonErrorCode.INVALID_INPUT_VALUE)
    protected constructor(value: String, errorCode: ErrorCode, vararg args: Any?) : super(value, errorCode, args)
    protected constructor(errorCode: ErrorCode, vararg args: Any?) : super(errorCode, args)

}
