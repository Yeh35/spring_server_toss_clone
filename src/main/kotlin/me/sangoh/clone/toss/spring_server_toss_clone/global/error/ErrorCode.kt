package me.sangoh.clone.toss.spring_server_toss_clone.global.error

import org.springframework.http.HttpStatus

/**
 * Error 처리에 사용되는 Enum들의 Interface이다.
 * 지원하길 원하는 국가가 생긴다면 getMessage{국가코드}로 추가하면 된다.
 * 국가코드는 아래 링크가 있다.
 * https://ko.wikipedia.org/wiki/%EA%B5%AD%EA%B0%80%EB%B3%84_%EA%B5%AD%EA%B0%80_%EC%BD%94%EB%93%9C_%EB%AA%A9%EB%A1%9D
 */
interface ErrorCode {
    fun getStatus(): HttpStatus
    fun getCode(): String
    fun getMessageEn(): String
    fun getMessageKo(): String
}
