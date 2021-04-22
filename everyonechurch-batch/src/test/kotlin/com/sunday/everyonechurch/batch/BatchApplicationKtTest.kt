package com.sunday.everyonechurch.batch

import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.junit.jupiter.SpringExtension

@Tag("integTest")
@ActiveProfiles("test")
@ExtendWith(SpringExtension::class)
@SpringBootTest(classes = [BatchApplication::class])
internal class BatchApplicationKtTest {
    @Test
    fun contextLoad() = Unit
}
