package com.ilirus.springcloud.exception.custom;

public class DataAlreadyExistException extends RuntimeException {
    public DataAlreadyExistException() {
        super("数据已存在");
    }

    public DataAlreadyExistException(String s) {
        super(s);
    }

    public DataAlreadyExistException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public DataAlreadyExistException(Throwable throwable) {
        super(throwable);
    }

    public DataAlreadyExistException(String s, Throwable throwable, boolean b, boolean b1) {
        super(s, throwable, b, b1);
    }
}
