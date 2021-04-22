package com.sunday.everyonechurch.application.exception

class EveryoneChurchApplicationException(message: String, var errorCode: String?) : RuntimeException(message) {

    constructor(message: String) : this(message, null) {
    }

    constructor(errorType: ErrorType) : this(errorType.message, null) {
        this.errorCode = errorType.errorCode
    }
}
