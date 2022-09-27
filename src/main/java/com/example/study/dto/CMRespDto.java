package com.example.study.dto;


import com.example.study.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

//오류 응답 Dto
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CMRespDto<T> {

    private int code;  //1(성공), -1(실패)
    private String message;
    private T data;
}
