package me.sangoh.clone.toss.spring_server_toss_clone.domain.member.application

import me.sangoh.clone.toss.spring_server_toss_clone.domain.member.dao.DeviceRepository
import me.sangoh.clone.toss.spring_server_toss_clone.domain.member.dao.MemberRepository
import me.sangoh.clone.toss.spring_server_toss_clone.domain.member.dto.DeviceWakeupDto
import me.sangoh.clone.toss.spring_server_toss_clone.global.utill.ULog
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Transactional(readOnly = true)
@Service
class DeviceService(
    private val deviceRepository: DeviceRepository
) {

    companion object: ULog

    @Transactional
    fun wakeup(wakeupDto: DeviceWakeupDto) {
        val device = deviceRepository.findByUuid(wakeupDto.uuid).orElseGet {
            deviceRepository.save(wakeupDto.toDevice())
        }

        device.checkAbnormal()
        device.checkMemberMapping()
        device.wakeup()

        deviceRepository.save(device)
    }
}
