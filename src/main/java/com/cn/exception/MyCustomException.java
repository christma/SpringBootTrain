package com.cn.exception;

public class MyCustomException extends RuntimeException{

    public MyCustomException(String errorMsg){
        super(errorMsg);
    }
}
