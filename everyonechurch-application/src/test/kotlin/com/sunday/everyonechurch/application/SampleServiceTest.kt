package com.sunday.everyonechurch.application

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import kotlin.random.Random

internal class SampleServiceTest {

    @Test
    fun smoke() {
        // Given
        val id = Random.nextLong()
        val sut = SampleService()

        // When
        val sampleValue = sut.getSampleValue(id)

        // Then
        assertEquals(sampleValue, "Value-$id")
    }
}
