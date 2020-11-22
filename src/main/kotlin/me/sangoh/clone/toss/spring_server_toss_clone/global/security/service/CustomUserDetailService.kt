package me.sangoh.clone.toss.spring_server_toss_clone.global.security.service

import me.sangoh.clone.toss.spring_server_toss_clone.domain.member.dao.DeviceRepository
import me.sangoh.clone.toss.spring_server_toss_clone.global.security.exception.CUserNotFoundException
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class CustomUserDetailService(
    private val deviceRepository: DeviceRepository
): UserDetailsService {

    override fun loadUserByUsername(username: String): UserDetails? {
        return deviceRepository.findById(username.toLong()).orElseThrow {
            CUserNotFoundException()
        }
    }
}