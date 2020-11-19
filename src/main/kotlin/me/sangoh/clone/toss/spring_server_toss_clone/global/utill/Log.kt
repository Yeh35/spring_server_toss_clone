package me.sangoh.clone.toss.spring_server_toss_clone.global.utill

import ch.qos.logback.classic.selector.servlet.LoggerContextFilter
import org.slf4j.Logger
import org.slf4j.LoggerFactory

/**
 * 로그를 남길 수 있게 하는 방법이다.
 * 사용방법은 사용하려는 클래스에 다음 코드를 추가하면 된다.
 * companion object : Log
 * Log.
 */
interface Log {

    val log: Logger
        get() {
            println("LoggerFactory 호출")
            return LoggerFactory.getLogger(this.javaClass)
        }

}