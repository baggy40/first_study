package com.example.study.service;

import com.example.study.entity.User;
import com.example.study.handler.ex.CustomValidationException;
import com.example.study.repository.ClubMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.lang.management.LockInfo;
import java.util.function.Supplier;

@Service
@RequiredArgsConstructor
public class UserService {

    private final ClubMemberRepository clubMemberRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    @Transactional
    public User modify(Long id, User user){

        //1.영속화
        User userEntity = clubMemberRepository.findById(id).orElseThrow(() ->{
                return new CustomValidationException("찾을 수 없는 id입니다");
        });

        //2.영속화된 오브젝트를 수정 - 더티체킹(업데이트 완료)
        userEntity.setName(user.getName());
        //비밀번호 해싱작업
        String rawPassword = user.getPassword();
        String encPassword = bCryptPasswordEncoder.encode(rawPassword);

        userEntity.setPassword(encPassword);
        userEntity.setBio(user.getBio());
        userEntity.setWebsite(user.getWebsite());
        userEntity.setPhone(user.getPhone());
        userEntity.setGender(user.getGender());

        return userEntity;
    }
}
