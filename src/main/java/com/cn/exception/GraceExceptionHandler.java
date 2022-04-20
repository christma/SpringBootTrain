package com.cn.exception;


import com.cn.utils.JsonResult;
import org.apache.tomcat.util.http.fileupload.impl.FileSizeLimitExceededException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GraceExceptionHandler {

    @ExceptionHandler(FileSizeLimitExceededException.class)
    @ResponseBody
    public JsonResult returnMaxFileSizeLimit(FileSizeLimitExceededException e){
        return JsonResult.errorMsg("文件大小不能超过500KB");
    }


    @ExceptionHandler(MyCustomException.class)
    @ResponseBody
    public JsonResult returnMyCustomException(MyCustomException e){
        return JsonResult.errorMsg(e.getMessage());
    }
}
