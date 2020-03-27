package com.ilirus.springcloud.enums;

import org.jetbrains.annotations.Contract;

public enum Status {
    SUCCESS(200,"成功"),
    FAIL(500,"失败"),
    NO_DATA_FOUND(404,"找不到对应的数据"),
    UNEXPECTED_ERROR(500, "意外的错误")
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
