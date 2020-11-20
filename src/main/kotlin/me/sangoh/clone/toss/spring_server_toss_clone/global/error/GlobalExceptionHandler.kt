package me.sangoh.clone.toss.spring_server_toss_clone.global.error

import me.sangoh.clone.toss.spring_server_toss_clone.global.error.exception.BusinessException
import me.sangoh.clone.toss.spring_server_toss_clone.global.utill.Log
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.BindException
import org.springframework.web.HttpRequestMethodNotSupportedException
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver
import java.nio.file.AccessDeniedException


@ControllerAdvice
class GlobalExceptionHandler {
    companion object : Log

//    /**
//     * javax.validation.Valid or @Validated 으로 binding error 발생시 발생한다.
//     * HttpMessageConverter 에서 등록한 HttpMessageConverter binding 못할경우 발생
//     * 주로 @RequestBody, @RequestPart 어노테이션에서 발생
//     */
//    @ExceptionHandler(MethodArgumentNotValidException::class)
//    protected fun handleMethodArgumentNotValidException(
//        request: WebRequest,
//        e: MethodArgumentNotValidException
//    ): ResponseEntity<ErrorResponse> {
//        log.error("handleMethodArgumentNotValidException", e)
////        val language = request.getHeader(HttpHeaders.ACCEPT_LANGUAGE);
////        val d = AcceptHeaderLocaleResolver(language)
//        val response = ErrorResponse.of(CommonErrorCode.INVALID_INPUT_VALUE, e.bindingResult)
//        return ResponseEntity(response, HttpStatus.BAD_REQUEST)
//    }
//
//    /**
//     * @ModelAttribut 으로 binding error 발생시 BindException 발생한다.
//     * ref https://docs.spring.io/spring/docs/current/spring-framework-reference/web.html#mvc-ann-modelattrib-method-args
//     */
//    @ExceptionHandler(BindException::class)
//    protected fun handleBindException(request: WebRequest, e: BindException): ResponseEntity<ErrorResponse> {
//        log.error("handleBindException", e)
//        val response = ErrorResponse.of(CommonErrorCode.INVALID_INPUT_VALUE, e.bindingResult)
//        return ResponseEntity(response, HttpStatus.BAD_REQUEST)
//    }
//
//    /**
//     * enum type 일치하지 않아 binding 못할 경우 발생
//     * 주로 @RequestParam enum으로 binding 못했을 경우 발생
//     */
//    @ExceptionHandler(MethodArgumentTypeMismatchException::class)
//    protected fun handleMethodArgumentTypeMismatchException(
//        request: WebRequest,
//        e: MethodArgumentTypeMismatchException?
//    ): ResponseEntity<ErrorResponse> {
//        log.error("handleMethodArgumentTypeMismatchException", e)
//        val response = ErrorResponse.of(e)
//        return ResponseEntity(response, HttpStatus.BAD_REQUEST)
//    }
//
//    /**
//     * 지원하지 않은 HTTP method 호출 할 경우 발생
//     */
//    @ExceptionHandler(HttpRequestMethodNotSupportedException::class)
//    protected fun handleHttpRequestMethodNotSupportedException(
//        request: WebRequest,
//        e: HttpRequestMethodNotSupportedException?
//    ): ResponseEntity<ErrorResponse> {
//        log.error("handleHttpRequestMethodNotSupportedException", e)
//        val response = ErrorResponse.of(CommonErrorCode.METHOD_NOT_ALLOWED)
//        return ResponseEntity(response, HttpStatus.METHOD_NOT_ALLOWED)
//    }
//
//    /**
//     * Authentication 객체가 필요한 권한을 보유하지 않은 경우 발생합
//     */
//    @ExceptionHandler(AccessDeniedException::class)
//    protected fun handleAccessDeniedException(
//        request: WebRequest,
//        e: AccessDeniedException?
//    ): ResponseEntity<ErrorResponse> {
//        log.error("handleAccessDeniedException", e)
//        val response = ErrorResponse.of(CommonErrorCode.HANDLE_ACCESS_DENIED)
//        return ResponseEntity(response, CommonErrorCode.HANDLE_ACCESS_DENIED.status)
//    }
//
//    @ExceptionHandler(BusinessException::class)
//    protected fun handleBusinessException(request: WebRequest, e: BusinessException): ResponseEntity<ErrorResponse> {
//        log.error("handleEntityNotFoundException", e)
//        val errorCode = e.getErrorCode()
//        val response = ErrorResponse.of(errorCode)
//        return ResponseEntity(response, errorCode.status)
//    }
//
//    @ExceptionHandler(Exception::class)
//    protected fun handleException(request: WebRequest, e: Exception?): ResponseEntity<ErrorResponse> {
//        log.error("handleEntityNotFoundException", e)
//        val response = ErrorResponse.of(CommonErrorCode.INTERNAL_SERVER_ERROR)
//        return ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR)
//    }
}