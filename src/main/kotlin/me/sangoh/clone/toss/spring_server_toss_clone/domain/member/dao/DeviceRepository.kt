package me.sangoh.clone.toss.spring_server_toss_clone.domain.member.dao

import me.sangoh.clone.toss.spring_server_toss_clone.domain.member.domain.Device
import me.sangoh.clone.toss.spring_server_toss_clone.global.common.base.BaseRepository
import java.util.*

interface DeviceRepository: BaseRepository<Device> {

    fun findByUuid(uuid: String): Optional<Device>

}