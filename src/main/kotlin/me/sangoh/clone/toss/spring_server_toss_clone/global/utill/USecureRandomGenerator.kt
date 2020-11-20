package me.sangoh.clone.toss.spring_server_toss_clone.global.utill

import java.security.SecureRandom
import java.util.*

/**
 * 랜덤한 숫자를 뽑는 함수
 */
object USecureRandomGenerator {

    private val secureRandom = SecureRandom.getInstance("SHA1PRNG")

    fun generate(length: Int): String {
        assert(length > 1) to "length must be a positive number."
        val random = SecureRandom()
        val bytes = ByteArray(length)
        random.nextBytes(bytes)
        val encoder: Base64.Encoder = Base64.getUrlEncoder().withoutPadding()
        return encoder.encodeToString(bytes).substring(0, length)
    }
}