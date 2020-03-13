package com.ilirus.springcloud.entities;

import com.ilirus.springcloud.enums.Status;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public class CommonResult<T> {
    private Integer code;
    private String message;
    private T data;

    @NotNull
    @Contract("_ -> new")
    public static<T> CommonResult<T> Of(@NotNull Status status) {
        return new CommonResult<T>(status.getCode(), status.getMessage());
    }

    @NotNull
    @Contract("_, _ -> new")
    public static<T> CommonResult<T> OfData(@NotNull Status status, T data) {
        return new CommonResult<T>(status.getCode(), status.getMessage(), data);
    }

    public CommonResult() {}

    private CommonResult(Integer code, String message) {
        this(code, message, null);
    }

    private CommonResult(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public Integer getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    public T getData() {
        return this.data;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setData(T data) {
        this.data = data;
    }
}
