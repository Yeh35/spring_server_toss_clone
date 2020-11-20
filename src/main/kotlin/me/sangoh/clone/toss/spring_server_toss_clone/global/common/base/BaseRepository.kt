package me.sangoh.clone.toss.spring_server_toss_clone.global.common.base

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.NoRepositoryBean

@NoRepositoryBean
interface BaseRepository<T>: JpaRepository<T, Long> {

}