package com.ilirus.springcloud.entities;

import com.ilirus.springcloud.enums.Status;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

@Data
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class CommonResult<T> {
    private Integer code;
    private String message;
    private T data;

    @NotNull
    @Contract("_ -> new")
    public static<T> CommonResult<T> of(@NotNull Status status) {
        return new CommonResult<T>(status.getCode(), status.getMessage(), null);
    }

    @NotNull
    @Contract("_, _ -> new")
    public static<T> CommonResult<T> ofData(@NotNull Status status, T data) {
        return new CommonResult<T>(status.getCode(), status.getMessage(), data);
    }

    @NotNull
    @Contract("_, _, _ -> new")
    public static<T> CommonResult<T> ofCustom(@NotNull Status status, @NotNull String message, T data) {
        return new CommonResult<>(status.getCode(), message, data);
    }
}
