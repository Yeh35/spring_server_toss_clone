package me.sangoh.clone.toss.spring_server_toss_clone.domain.member.api

import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiParam
import me.sangoh.clone.toss.spring_server_toss_clone.domain.member.application.DeviceService
import me.sangoh.clone.toss.spring_server_toss_clone.domain.member.domain.Device
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@Api(tags = ["Device"])
@RequestMapping("/devices")
@RestController
class DeviceApi(
    val deviceService: DeviceService
) {

    @ApiOperation(value = "회원가입", notes = "설치후 앱이 처음으로 실행될 때 호출된다.")
    @PostMapping
    fun enrollment (
        @ApiParam(value = "Android ID or Apple UUID or Mac address", required = true) @RequestBody uuid: String
    ) {
        deviceService.enrollment(uuid)
    }

}