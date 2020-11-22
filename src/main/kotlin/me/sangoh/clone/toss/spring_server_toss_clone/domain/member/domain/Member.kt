package me.sangoh.clone.toss.spring_server_toss_clone.domain.member.domain

import me.sangoh.clone.toss.spring_server_toss_clone.domain.model.*
import me.sangoh.clone.toss.spring_server_toss_clone.global.common.base.BaseEntity
import java.time.LocalDate
import javax.persistence.*

@Entity
@Table(name = "member")
class Member(
    roles: List<Role> = listOf(Role.USER),
    name: Name,
    phoneNumber: PhoneNumber,
    gender: Gender,
    birthday: LocalDate
): BaseEntity() {

    @ElementCollection(fetch = FetchType.EAGER)
    val roles: List<Role> = roles

    @Embedded
    @AttributeOverrides(
        AttributeOverride(name = "first", column = Column(name = "first_name", nullable = false)),
        AttributeOverride(name = "middle", column = Column(name = "middle_name")),
        AttributeOverride(name = "last", column = Column(name = "last_name", nullable = false))
    )
    var name: Name = name
        private set

    @Embedded
    @AttributeOverrides(
        AttributeOverride(name = "first", column = Column(name = "phone_first_number", nullable = false)),
        AttributeOverride(name = "middle", column = Column(name = "phone_middle_number", nullable = false)),
        AttributeOverride(name = "last", column = Column(name = "phone_last_number", nullable = false))
    )
    var phoneNumber: PhoneNumber = phoneNumber
        private set

    @Column(name = "birthday", nullable = false)
    var birthday: LocalDate = birthday
        private set

    @Enumerated(EnumType.STRING)
    var gender: Gender = gender
        private set

    @Column(nullable = false, unique = false, length = 32)
    private var payPassword: String = ""

    @Column(nullable = false, unique = false, length = 32)
    private var payPasswordSalt: String = ""

    // 맞춤형 서비스 안내 동의
    @Column(unique = false, nullable = false)
    var termsCustomizedService: Boolean = false
        private set

    //마케팅 정보 수신 동의
    @Column(unique = false, nullable = false)
    var termsMarketingInformation: Boolean = false
        private set

    fun updateProfile(name: Name) {
        this.name = name
    }

    fun confirmTerms(termsCustomizedService: Boolean, termsMarketingInformation: Boolean) {
        this.termsCustomizedService = termsCustomizedService
        this.termsMarketingInformation = termsMarketingInformation
    }
}