package me.sangoh.clone.toss.spring_server_toss_clone.domain.member.application

import me.sangoh.clone.toss.spring_server_toss_clone.domain.member.dao.DeviceRepository
import me.sangoh.clone.toss.spring_server_toss_clone.domain.member.domain.Device
import me.sangoh.clone.toss.spring_server_toss_clone.domain.member.dto.DeviceSignupDto
import me.sangoh.clone.toss.spring_server_toss_clone.global.utill.ULog
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Transactional(readOnly = true)
@Service
class DeviceService(
    private val deviceRepository: DeviceRepository
) {

    companion object : ULog

    @Transactional
    fun enrollment(uuid: String) {

        val device = deviceRepository.findByUuid(uuid).orElseGet {
            deviceRepository.save(Device(uuid = uuid))
        }

        device.checkAbnormal()
        device.checkMemberMapping()

        log.info("디바이스 등록: {}", device)
    }
}
