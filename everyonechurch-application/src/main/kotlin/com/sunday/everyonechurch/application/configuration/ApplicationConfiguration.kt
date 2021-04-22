package com.sunday.everyonechurch.application.configuration

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Configuration

@Configuration
class ApplicationConfiguration(
) {
    @Value("\${app.id}")
    private val appId: String? = null

    @Value("\${spring.profiles.active:local}")
    private val profile: String? = null
}
