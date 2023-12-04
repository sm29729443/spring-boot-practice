package com.example.springbootpractice.validationpractice.exception;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.support.DefaultHandlerExceptionResolver;
import org.xml.sax.helpers.DefaultHandler;

import java.util.List;

@ControllerAdvice
@Slf4j
public class MyExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> test1(MethodArgumentNotValidException methodArgumentNotValidException) {
        methodArgumentNotValidException.printStackTrace();
        List<ObjectError> allErrors = methodArgumentNotValidException.getAllErrors();
        StringBuilder message = new StringBuilder();
        for (ObjectError error : allErrors) {
            // 若是需要詳細訊息使用 getDefaultMessage
            log.warn("arg:{}",error.getDefaultMessage());
            message.append("[");
            message.append(( (FieldError) error).getField());
            message.append("];");
        }
        log.warn("參數驗證錯誤:" + message.toString());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message.toString());
    }
}
