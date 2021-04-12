package com.smhrd.exception;

import lombok.Getter;

public enum MemberErrorCode {
    NOT_NULL("ERROR_NOT_NULL", "필수 입력 값입니다."),
    INVALID_DATE("ERROR_INVALID_DATE", "잘못된 날짜입니다."),
    INVALID_EMAIL("ERROR_INVALID_EMAIL", "잘못된 이메일 형식입니다.");

    @Getter
    private String code;

    @Getter
    private String description;

    MemberErrorCode(String code, String description) {
        this.code = code;
        this.description = description;
    }
}
