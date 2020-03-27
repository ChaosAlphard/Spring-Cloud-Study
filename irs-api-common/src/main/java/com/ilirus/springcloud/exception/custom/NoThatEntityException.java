package com.ilirus.springcloud.exception.custom;

public class NoThatEntityException extends RuntimeException {
    public NoThatEntityException() {
        super("找不到对应的数据");
    }

    public NoThatEntityException(String s) {
        super(s);
    }

    public NoThatEntityException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public NoThatEntityException(Throwable throwable) {
        super(throwable);
    }

    public NoThatEntityException(String s, Throwable throwable, boolean b, boolean b1) {
        super(s, throwable, b, b1);
    }
}
