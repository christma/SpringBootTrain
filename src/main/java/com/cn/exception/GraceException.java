package com.cn.exception;

public class GraceException {

    public static void display(String errMsg) {
        throw new MyCustomException(errMsg);
    }
}
