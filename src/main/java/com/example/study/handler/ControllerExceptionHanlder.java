package com.example.study.handler;

import com.example.study.dto.CMRespDto;
import com.example.study.handler.ex.CustomApiException;
import com.example.study.handler.ex.CustomValidationException;
import com.example.study.util.Script;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController  //데이터를 리턴
@ControllerAdvice //controller에서 나타나는 모든 exception을 낚아챈다
public class ControllerExceptionHanlder {

    @ExceptionHandler(CustomValidationException.class)
    public String validationException(CustomValidationException e){
        return Script.back(e.getErrorMap().toString());
    }

    @ExceptionHandler(CustomApiException.class)
    public ResponseEntity<?> apiException(CustomApiException e){

        return new ResponseEntity<>(new CMRespDto<>(-1, e.getMessage(),null), HttpStatus.BAD_REQUEST);
    }
}
