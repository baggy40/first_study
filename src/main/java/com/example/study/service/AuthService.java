package com.example.study.service;

import com.example.study.entity.User;
import com.example.study.repository.ClubMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service //Ioc, 트랜잭션 관리
@RequiredArgsConstructor
public class AuthService {

    private final ClubMemberRepository clubMemberRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Transactional
    public User register(User user){

        String rawPassword = user.getPassword();
        String encPassword = bCryptPasswordEncoder.encode(rawPassword);
        user.setPassword(encPassword);
        user.setRole("ROLE_USER"); //기본 권한
        User userEntity = clubMemberRepository.save(user);
        return userEntity;
    }
}
