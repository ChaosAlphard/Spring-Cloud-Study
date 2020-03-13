package com.ilirus.springcloud.enums;

import org.jetbrains.annotations.Contract;

public enum Status {
    SUCCESS(200,"sucess"),
    FAIL(400,"fail"),
    NO_DATA_FOUND(404,"not found")
    ;

    private Integer code;
    private String message;

    Status(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    @Contract(pure = true)
    public Integer getCode() {
        return code;
    }

    @Contract(pure = true)
    public String getMessage() {
        return message;
    }
}
