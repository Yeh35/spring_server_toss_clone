package me.sangoh.clone.toss.spring_server_toss_clone.domain.member.api

import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import me.sangoh.clone.toss.spring_server_toss_clone.domain.member.dto.DeviceWakeupDto
import me.sangoh.clone.toss.spring_server_toss_clone.domain.member.application.DeviceService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@Api(tags = ["디바이스"])
@RequestMapping("/devices")
@RestController
class DeviceApi(
    private val deviceService: DeviceService
) {

    @ApiOperation(value = "첫 시작", notes = "설치후 앱이 처음으로 실행될 때 호출된다.")
    @PostMapping("/wakeup/first")
    fun  wakeupDeviceFirst(
        @RequestBody wakeupDto: DeviceWakeupDto
    ) {

        deviceService.wakeup(wakeupDto)

    }

    @ApiOperation(value = "시작", notes = "앱이 실행될 때 호출된다.")
    @PostMapping("/wakeup")
    fun wakeupDevice(
        @RequestBody wakeupDto: DeviceWakeupDto
    ) {


    }
}