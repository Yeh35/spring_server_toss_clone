package me.sangoh.clone.toss.spring_server_toss_clone.domain.member.api

import io.swagger.annotations.Api
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 *  로그인 API
 */
@Api(tags = ["로그인 API"])
@RestController
class SignApi {


    @PostMapping(value = ["/signin"])
    fun sign(

    ) {

    }

}