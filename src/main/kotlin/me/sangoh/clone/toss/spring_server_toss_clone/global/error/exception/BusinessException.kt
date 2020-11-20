package me.sangoh.clone.toss.spring_server_toss_clone.global.error.exception

import me.sangoh.clone.toss.spring_server_toss_clone.global.error.ErrorCode

/**
 * Business 로직과 관련된 Exception의 초상위 Exception이다.
 */
abstract class BusinessException : RuntimeException {
    val errorCode: ErrorCode

    /**
     * message는 로그용으로 사용됨으로 개발자가 좀 더 다양한 메시지를 남길 수 있도록 열어두었다.
     */
    constructor(message: String?, errorCode: ErrorCode) : super(message) {
        this.errorCode = errorCode
    }

    /**
     * Exception Message는 로그용으로 나가게 된다.
     */
    constructor(errorCode: ErrorCode) : super(errorCode.getMessageKo()) {
        this.errorCode = errorCode
    }
}
