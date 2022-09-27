package com.example.study.config.auth;

import com.example.study.entity.User;
import com.example.study.repository.ClubMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PrincipalDetailsService implements UserDetailsService {
    private final ClubMemberRepository clubMemberRepository;

    //1. 패스워드는 알아서 체크해줌
    //2. 리턴이 잘되면 자동으로 UserDetails타입을 세션으로 만들어 준다
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User userEntity  = clubMemberRepository.findByUsername(username);

        if(userEntity ==null){
            return null;
        }else{
            return new PrincipalDetails(userEntity);
        }

    }
}
