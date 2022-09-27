package com.example.study.controller;

import com.example.study.dto.SignupDto;
import com.example.study.entity.User;
import com.example.study.handler.ex.CustomValidationException;
import com.example.study.service.AuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@Controller
@Log4j2
@RequiredArgsConstructor // final 필드를 DI 할때 사용
public class AuthController {

    private final AuthService authService;

    @GetMapping("/auth/signin")
    public String signinForm(){
        return "auth/signin";
    }

    @GetMapping("/auth/signup")
    public String signinUpForm(){
        return "auth/signup";
    }
    @PostMapping("/auth/signup")
    public String signinUp(@Valid SignupDto signupDto, BindingResult bindingResult){
        //@valid 유효성 검사

        if(bindingResult.hasErrors()){
            Map<String,String> errorMap = new HashMap<>();

            for(FieldError error : bindingResult.getFieldErrors()){
                errorMap.put(error.getField(), error.getDefaultMessage());
                System.out.println("=========================");
                System.out.println(error.getDefaultMessage());
                System.out.println("=========================");
            }
            throw new CustomValidationException("유효성 검사 실패함",errorMap);
        }else {
            User user = signupDto.toEntity();
            User userEntity = authService.register(user);
            System.out.println(userEntity);
            return "auth/signin";
        }
    }
}
