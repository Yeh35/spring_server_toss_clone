package me.sangoh.clone.toss.spring_server_toss_clone.domain.member.domain

import me.sangoh.clone.toss.spring_server_toss_clone.domain.member.error.AbnormalDeviceException
import me.sangoh.clone.toss.spring_server_toss_clone.domain.member.error.NotWakeupTooLongException
import me.sangoh.clone.toss.spring_server_toss_clone.global.common.base.BaseEntity
import me.sangoh.clone.toss.spring_server_toss_clone.global.utill.USecureRandomGenerator
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import java.security.SecureRandom
import java.time.LocalDateTime
import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Table

@Entity
@Table(name = "device")
class Device(
    uuid: String
) : BaseEntity(), UserDetails {

    /**
     * Android ID or Apple UUID or Mac address
     */
    @Column(nullable = false, unique = false, length = 32)
    val uuid: String = uuid

    @Column(nullable = false, unique = false)
    var member: Member? = null
        private set

    @Column(nullable = false, unique = false, length = 32)
    var memberMappingAt: LocalDateTime = LocalDateTime.MIN
        private set

    @Column(nullable = false, unique = false)
    var abnormal: Boolean = false
        private set

    @Column(nullable = false, unique = false)
    private var password: UUID = UUID.randomUUID()

    fun mapping(member: Member) {
        if (this.member == member) {
            return
        } else if (this.member != null) {
            //TODO 로그아웃하지 않고 로그인 하는 경우 차단 해야할까?
        }

        memberMappingAt = LocalDateTime.now()
        this.member = member
    }

    /**
     * 비 정상적인지 검토
     */
    fun checkAbnormal() {
        if (abnormal) {
            throw AbnormalDeviceException.of(this)
        }
    }

    fun checkMemberMapping() {
        if (member == null) {
            throw AbnormalDeviceException.of(this)
        }
    }

    override fun getAuthorities(): MutableCollection<out GrantedAuthority> {
        TODO("Not yet implemented")
    }

    override fun getPassword(): String {
        return password.toString()
    }

    override fun getUsername(): String {
        TODO("Not yet implemented")
    }

    override fun isAccountNonExpired(): Boolean {
        TODO("Not yet implemented")
    }

    override fun isAccountNonLocked(): Boolean {
        TODO("Not yet implemented")
    }

    override fun isCredentialsNonExpired(): Boolean {
        TODO("Not yet implemented")
    }

    override fun isEnabled(): Boolean {
        TODO("Not yet implemented")
    }

}