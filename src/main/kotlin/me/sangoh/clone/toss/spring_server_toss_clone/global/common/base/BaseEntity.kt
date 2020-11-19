package me.sangoh.clone.toss.spring_server_toss_clone.global.common.base

import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime
import javax.persistence.*

@MappedSuperclass
open class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    val id: Long = 0

    @CreationTimestamp
    @Column(name = "create_at", nullable = false, updatable = false)
    lateinit var createAt: LocalDateTime
        private set

    @UpdateTimestamp
    @Column(name = "update_at", nullable = false)
    lateinit var updateAt: LocalDateTime
        private set
}
