package com.sunday.everyonechurch.api.facade

import com.sunday.everyonechurch.application.SampleService
import org.springframework.stereotype.Component

@Component
class SampleApiImpl(private val sampleService: SampleService) {
    fun getSample(id: Long): String {
        val value = sampleService.getSampleValue(id)

        return value
    }

}
