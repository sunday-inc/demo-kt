package com.sunday.everyonechurch.api.configuration

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.ResponseStatus

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.web.HttpRequestMethodNotSupportedException
import javax.servlet.http.HttpServletRequest

@ControllerAdvice
class ControllerAdvice {

    val logger: Logger = LoggerFactory.getLogger(ControllerAdvice::class.java)

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(HttpRequestMethodNotSupportedException::class)
    @ResponseBody
    fun handleMethodNotSupportedException(request: HttpServletRequest,
                                          e: HttpRequestMethodNotSupportedException): String? {
        logger.info("{} SupportedMethods:{}, URL:{} ", e.message, e.supportedHttpMethods,
                request.requestURL)
        return e.message
    }
}
