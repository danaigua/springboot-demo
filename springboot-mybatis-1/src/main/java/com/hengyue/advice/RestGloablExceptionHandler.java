package com.hengyue.advice;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class RestGloablExceptionHandler {
    public static final String DEFAULT_ERROR_VIEW = "error";

    @ExceptionHandler(value = Exception.class)
    public Object defaultErrorHandler(HttpServletRequest request, Exception e){
        class ErrorInfo{
            private Integer code;
            private String msg;
            private String url;

            public Integer getCode() {
                return code;
            }

            public void setCode(Integer code) {
                this.code = code;
            }

            public String getMsg() {
                return msg;
            }

            public void setMsg(String msg) {
                this.msg = msg;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            @Override
            public String toString() {
                return "ErrorInfo{" +
                        "code=" + code +
                        ", msg='" + msg + '\'' +
                        ", url='" + url + '\'' +
                        '}';
            }

            public ErrorInfo(Integer code, String msg, String url) {
                this.code = code;
                this.msg = msg;
                this.url = url;
            }

            public ErrorInfo() {
            }
        }
        return new ErrorInfo(100, e.getMessage(), request.getRequestURI());
    }

}
