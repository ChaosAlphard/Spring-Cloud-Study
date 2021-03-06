package com.ilirus.springcloud.exception;

import com.ilirus.springcloud.entities.CommonResult;
import com.ilirus.springcloud.enums.Status;
import com.ilirus.springcloud.exception.custom.NoThatEntityException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.net.SocketTimeoutException;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler({NoThatEntityException.class})
    @ResponseStatus(HttpStatus.OK)
    public CommonResult notFound(NoThatEntityException ntee) {
        log.error("在数据库中找不到对应的实体", ntee);
        return CommonResult.of(Status.NO_DATA_FOUND);
    }

    @ExceptionHandler({Exception.class})
    @ResponseStatus(HttpStatus.OK)
    public CommonResult uncatchedError(Exception e) {
        log.error("意外的错误", e);
        return CommonResult.of(Status.UNEXPECTED_ERROR);
    }
}
