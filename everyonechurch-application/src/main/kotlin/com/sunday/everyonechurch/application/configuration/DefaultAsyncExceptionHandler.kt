package com.sunday.everyonechurch.application.configuration

import java.lang.reflect.Method

import org.slf4j.LoggerFactory
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler

class DefaultAsyncExceptionHandler : AsyncUncaughtExceptionHandler {

    override fun handleUncaughtException(throwable: Throwable, method: Method, vararg objects: Any) {
        logger.error("async exception :: ", throwable)
    }

    companion object {
        private val logger = LoggerFactory.getLogger(DefaultAsyncExceptionHandler::class.java)
    }
}
