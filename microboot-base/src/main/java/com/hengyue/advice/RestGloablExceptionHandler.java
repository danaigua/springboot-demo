package com.hengyue.advice;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class RestGloablExceptionHandler {

    public static final String DEFAULT_ERROR_VIEW = "error";        /* 定义错误显示页 error.html */

    @ExceptionHandler(value = Exception.class)
    public Object defaultErrorHandler(HttpServletRequest request, Exception e){
        class ErrorInfo{
            private String code;
            private String message;
            private String url;

            public String getCode() {
                return code;
            }

            public void setCode(String code) {
                this.code = code;
            }

            public String getMessage() {
                return message;
            }

            public void setMessage(String message) {
                this.message = message;
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
                        "code='" + code + '\'' +
                        ", message='" + message + '\'' +
                        ", url='" + url + '\'' +
                        '}';
            }

            public ErrorInfo() {
            }

            public ErrorInfo(String code, String message, String url) {
                this.code = code;
                this.message = message;
                this.url = url;
            }
        }

        return new ErrorInfo("100", e.getMessage(), request.getRequestURI());
    }

}
