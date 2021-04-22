package com.sunday.everyonechurch.application.exception

enum class ErrorType {
    COMMON_ERROR("처리중 오류가 발생 했습니다."),
    NOT_FOUND("존재하지 않는 정보 입니다", "4040"),
    INVALID_REQUEST("잘못된 요청입니다.", "4000");

    var message: String

    var errorCode: String? = null

    constructor(message: String) {
        this.message = message
    }

    constructor(message: String, errorCode: String) {
        this.message = message
        this.errorCode = errorCode
    }
}
