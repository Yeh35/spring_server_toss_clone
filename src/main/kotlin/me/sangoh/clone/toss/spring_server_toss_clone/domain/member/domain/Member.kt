package me.sangoh.clone.toss.spring_server_toss_clone.domain.member.domain

import me.sangoh.clone.toss.spring_server_toss_clone.domain.model.Email
import me.sangoh.clone.toss.spring_server_toss_clone.domain.model.Name
import me.sangoh.clone.toss.spring_server_toss_clone.global.common.base.BaseEntity
import javax.persistence.*

@Entity
@Table(name = "member")
class Member(
    email: Email,
    name: Name
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

    fun updateProfile(name: Name) {
        this.name = name
    }
}