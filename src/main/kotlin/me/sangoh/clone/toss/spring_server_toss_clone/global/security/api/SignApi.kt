package me.sangoh.clone.toss.spring_server_toss_clone.global.security.api

import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import me.sangoh.clone.toss.spring_server_toss_clone.domain.member.dto.DeviceSignupDto
import me.sangoh.clone.toss.spring_server_toss_clone.domain.member.application.DeviceSignService
import me.sangoh.clone.toss.spring_server_toss_clone.domain.member.dao.MemberRepository
import me.sangoh.clone.toss.spring_server_toss_clone.domain.member.domain.Member
import me.sangoh.clone.toss.spring_server_toss_clone.global.security.dto.SignupDto
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@Api(tags = ["Sign"])
@RestController
class SignApi(
    private val deviceSignService: DeviceSignService,
    private val memberRepository: MemberRepository
) {

    @ApiOperation(value = "회원가입", notes = "설치후 앱이 처음으로 실행될 때 호출된다.")
    @PostMapping("/signin")
    fun wakeupDeviceFirst(
        @RequestBody wakeupDto: DeviceSignupDto
    ) {

//        deviceSignService.(wakeupDto)

    }

    @ApiOperation(value = "시작", notes = "앱이 실행될 때 호출된다.")
    @PostMapping("/signup")
    fun wakeupDevice(
        @RequestBody signupDto: SignupDto
    ) {
        val member = memberRepository.save(
            Member(
                name = signupDto.name,
                phoneNumber = signupDto.phoneNumber,
                gender = signupDto.gender,
                birthday = signupDto.birthday
            )
        )

        member.confirmTerms(
            termsCustomizedService = signupDto.termsCustomizedService,
            termsMarketingInformation = signupDto.termsMarketingInformation
        )
    }
}