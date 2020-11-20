package me.sangoh.clone.toss.spring_server_toss_clone.global.utill

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class USecureRandomGeneratorTest {

    @Test
    fun testSecureRandomGenerator() {
        val randomText = USecureRandomGenerator.generate(32)
        println("randomText: ${randomText}")
        assertEquals(32, randomText.length)
    }

}