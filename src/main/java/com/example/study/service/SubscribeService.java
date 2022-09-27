package com.example.study.service;

import com.example.study.domain.subscribe.Subscribe;
import com.example.study.domain.subscribe.SubscribeRepository;
import com.example.study.handler.ex.CustomApiException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class SubscribeService {

    private final SubscribeRepository subscribeRepository;

    @Transactional
    public void select(Long fromUserId, int toUserId){
        try{
            subscribeRepository.mSubscribe(fromUserId, toUserId);
        }catch (Exception e){
            throw new CustomApiException("이미 구독을 하였습니다.");
        }
    }

    @Transactional
    public void cancle(Long fromUserId, int toUserId){
         subscribeRepository.mUnSubscribe(fromUserId,toUserId);
    }
}
