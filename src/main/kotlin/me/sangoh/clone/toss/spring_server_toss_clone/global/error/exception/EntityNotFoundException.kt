package me.sangoh.clone.toss.spring_server_toss_clone.global.error.exception

import me.sangoh.clone.toss.spring_server_toss_clone.global.error.CommonErrorCode
import me.sangoh.clone.toss.spring_server_toss_clone.global.error.ErrorCode

/**
 * 엔티티 개체를 찾지 못한경우 발생한다. (주로 데이터 없음 예외)
 */
class EntityNotFoundException : BusinessException {
    constructor(value: String?) : super(value, CommonErrorCode.ENTITY_NOT_FOUND)
    constructor(value: String?, errorCode: ErrorCode, vararg args: Any?) : super(value, errorCode, args)
    constructor(errorCode: ErrorCode, vararg args: Any?) : super(errorCode, args)
}
