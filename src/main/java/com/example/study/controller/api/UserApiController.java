package com.example.study.controller.api;

import com.example.study.config.auth.PrincipalDetails;
import com.example.study.dto.CMRespDto;
import com.example.study.dto.user.UserUpdateDto;
import com.example.study.entity.User;
import com.example.study.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserApiController {

    private final UserService userService;

    @PutMapping("/api/user/{id}")
    public CMRespDto<?> update(@PathVariable Long id, UserUpdateDto userUpdateDto, @AuthenticationPrincipal PrincipalDetails principalDetails){

        User userEntity = userService.modify(id,userUpdateDto.toEntity());
        principalDetails.setUser(userEntity);
        return new CMRespDto<>(1,"회원수정완료",userEntity);
    }

}
