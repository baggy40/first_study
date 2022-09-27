package com.example.study.dto;


import com.example.study.entity.TransEntity;
import lombok.*;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class TransDTO {

    private String routeName;
    private String stdDate;
    private int stdHour;
    private int trafficAmout;
    private int speed;
    private int shareRatio;
    private int timeAvg;
    private int routeNo;
    private String updownTypeCode;
    private String conzoneId;
    private String conzoneName;
    private String vdsId;
    private int grade;

    public TransEntity toEntity(){
        return TransEntity.builder()
                .routeName(this.routeName)
                .stdDate(this.stdDate)
                .stdHour(this.stdHour)
                .trafficAmout(this.trafficAmout)
                .speed(this.speed)
                .shareRatio(this.shareRatio)
                .timeAvg(this.timeAvg)
                .routeNo(this.routeNo)
                .updownTypeCode(this.updownTypeCode)
                .conzoneId(this.conzoneId)
                .conzoneName(this.conzoneName)
                .vdsId(this.vdsId)
                .grade(this.grade)
                .build();
    }

    public TransEntity toEntityTwo(){
        return new TransEntity(routeName,stdDate,stdHour,trafficAmout,speed,shareRatio,timeAvg,routeNo,updownTypeCode,conzoneId,conzoneName,vdsId,grade);
    }

}
