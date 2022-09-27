package com.example.study.controller;

import com.example.study.dto.TransDTO;
import com.example.study.entity.TransEntity;
import com.example.study.repository.TransRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@Log4j2
@RequestMapping("/sample/")
public class SampleController {

    @Autowired
    private TransRepository transRepository;

    @GetMapping("/all")
    public void exAll(){
        log.info("exAll...................");
    }
    @GetMapping("/main")
    public void main(){
        log.info("main.........");
    }

    @GetMapping("/member")
    public void exMember(){
        log.info("exMemeber.........");
    }
    @GetMapping("/admin")
    public void exAdmin(){
        log.info("exAdimn...............");
    }

    @GetMapping("/traffic")
    public String traffic(Model model){
        // List<TransEntity> findEntity = transRepository.findAll(Sort.by(Sort.Direction.DESC,"trafficAmout"));
        List<TransEntity> findEntity = transRepository.findTop10ByOrderByTrafficAmoutDesc();

        List<TransDTO> collect = findEntity.stream().map(TransEntity::toDto).collect(Collectors.toList());

        model.addAttribute("list",collect);
        // System.out.println(collect);

        return "sample/trans";
    }

    @PostMapping("/transInfo")
    public String memberList(@RequestParam Map<String, Object> parameters, Model model){
        System.out.println("=========================transInfo");
        String json = parameters.get("paramList").toString();
        List<TransDTO> paramList;

        ObjectMapper mapper = new ObjectMapper();
        try {

            //List<Map<String, Object>> paramList = mapper.readValue(json, new TypeReference<ArrayList<Map<String, Object>>>(){});
            paramList = mapper.readValue(json, new TypeReference<ArrayList<TransDTO>>(){});

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        //먼저 삭제처리
        transRepository.deleteAllInBatch();
        //paramList.forEach(System.out::println);
        List<TransEntity> item = paramList.stream().map(TransDTO::toEntity)
                .collect(Collectors.toList());

        transRepository.saveAll(item);

        //transRepository.saveAll(paramList);
        /*paramList.stream().map(o ->o.getRouteName()).collect(Collectors.toList());
        System.out.println(paramList.stream().map(o ->o.getSpeed()).collect(Collectors.toList()));
        paramList.stream().map(o ->o.getStdDate()).collect(Collectors.toList());
        paramList.stream().map(o ->o.getStdHour()).collect(Collectors.toList());
        paramList.stream().map(o ->o.getTrafficAmout()).collect(Collectors.toList());
        paramList.stream().map(o ->o.getSpeed()).collect(Collectors.toList());
        paramList.stream().map(o ->o.getShareRatio()).collect(Collectors.toList());
        paramList.stream().map(o ->o.getTimeAvg()).collect(Collectors.toList());
        paramList.stream().map(o ->o.getRouteNo()).collect(Collectors.toList());
        paramList.stream().map(o ->o.getUpdownTypeCode()).collect(Collectors.toList());
        paramList.stream().map(o ->o.getConzoneId()).collect(Collectors.toList());
        paramList.stream().map(o ->o.getConzoneName()).collect(Collectors.toList());
        paramList.stream().map(o ->o.getVdsId()).collect(Collectors.toList());
        paramList.stream().map(o ->o.getGrade()).collect(Collectors.toList());*/

        System.out.println("========================여기부터");

        return "sample/admin";
    }




}
