package me.sangoh.clone.toss.spring_server_toss_clone.domain.member.domain

import me.sangoh.clone.toss.spring_server_toss_clone.domain.model.Email
import me.sangoh.clone.toss.spring_server_toss_clone.domain.model.Gender
import me.sangoh.clone.toss.spring_server_toss_clone.domain.model.Name
import me.sangoh.clone.toss.spring_server_toss_clone.domain.model.PhoneNumber
import me.sangoh.clone.toss.spring_server_toss_clone.global.common.base.BaseEntity
import java.time.LocalDate
import javax.persistence.*

@Entity
@Table(name = "member")
class Member(
    email: Email,
    name: Name,
    phoneNumber: PhoneNumber,
    gender: Gender,
    birthday: LocalDate
): BaseEntity() {

    @Embedded
    @AttributeOverride(
        name = "value",
        column = Column(name = "email", nullable = false, unique = true, updatable = false, length = 50)
    )
    var email: Email = email
        private set

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
    var payPassword: String = ""
    private set

    @Column(nullable = false, unique = false, length = 32)
    private var payPasswordSalt: String = ""

    // 맞춤형 서비스 안내 동의
    @Column(unique = false, nullable = false)
    private var termsCustomizedService: Boolean = false

    //마케팅 정보 수신 동의
    @Column(unique = false, nullable = false)
    private var termsMarketingInformation: Boolean = false

    fun updateProfile(name: Name) {
        this.name = name
    }
}