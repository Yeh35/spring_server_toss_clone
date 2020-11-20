package me.sangoh.clone.toss.spring_server_toss_clone.global.error

import org.springframework.http.HttpStatus
import org.springframework.validation.BindingResult
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException
import java.util.*
import java.util.stream.Collectors

/**
 * Error Response 객체는 항상 동일한 Error Response를 사용함으로써 Server에서도 Client에도
 * 동일한 로직으로 Error 처리를 함으로써 코드의 복잡성을 떨어트릴 수 있다.
 * 절대 `Map<Key, Value>` 처리 하지 말자 (런타임시에 형태를 지정하기에 버그를 사전에 확인하기 힘들다.)
 */

class ErrorResponse {

//    private val message: String
//    private val status: HttpStatus
//    private val errors: List<FieldError>
//    private val code: String
//
//    private constructor(code: ErrorCode, errors: List<FieldError>) {
//
//        this.message = code.getMessage()
//        this.status = code.getStatus()
//        this.errors = errors
//        this.code = code.getCode()
//    }
//
//    private constructor(code: ErrorCode) {
//        this.message = code.getMessage()
//        this.status = code.getStatus()
//        this.code = code.getCode()
//        this.errors = ArrayList()
//    }
//
//    fun of(code: ErrorCode, bindingResult: BindingResult): ErrorResponse? {
//        return ErrorResponse(code, FieldError.of(bindingResult))
//    }
//
//    fun of(code: ErrorCode): ErrorResponse? {
//        return ErrorResponse(code)
//    }
//
//    fun of(code: ErrorCode, errors: List<FieldError>): ErrorResponse? {
//        return ErrorResponse(code, errors)
//    }
//
//    fun of(e: MethodArgumentTypeMismatchException): ErrorResponse? {
//        val value = if (e.value == null) "" else e.value.toString()
//        val errors = FieldError.of(e.name, value, e.errorCode)
//        return ErrorResponse(CommonErrorCode.INVALID_TYPE_VALUE, errors)
//    }
//
//    class FieldError private constructor(
//        private val field: String,
//        private val value: String,
//        private val reason: String?
//    ) {
//        companion object {
//            fun of(field: String, value: String, reason: String?): List<FieldError> {
//                val fieldErrors: MutableList<FieldError> = ArrayList()
//                fieldErrors.add(FieldError(field, value, reason))
//                return fieldErrors
//            }
//
//            private fun of(bindingResult: BindingResult): List<FieldError> {
//                val fieldErrors = bindingResult.fieldErrors
//                return fieldErrors.stream()
//                    .map { error: org.springframework.validation.FieldError ->
//                        FieldError(
//                            error.field,
//                            if (error.rejectedValue == null) "" else error.rejectedValue.toString(),
//                            error.defaultMessage
//                        )
//                    }
//                    .collect(Collectors.toList())
//            }
//        }
//    }
}