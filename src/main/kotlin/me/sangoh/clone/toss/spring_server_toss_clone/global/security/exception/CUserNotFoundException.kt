package me.sangoh.clone.toss.spring_server_toss_clone.global.security.exception

class CUserNotFoundException : RuntimeException {
    constructor(msg: String?, t: Throwable?) : super(msg, t)
    constructor(msg: String?) : super(msg)
    constructor() : super()
}