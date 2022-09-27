package com.example.study.entity;


import com.example.study.dto.TransDTO;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="trans_tbl")
@ToString
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TransEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mno;

    @Column(length = 255, nullable = false)
    private String routeName;

    @Column(length = 255, nullable = false)
    private String stdDate;

    @Column(length = 255, nullable = false)
    private int stdHour;
    @Column(length = 255, nullable = false)
    private int trafficAmout;

    @Column(length = 255, nullable = false)
    private int speed;
    @Column(length = 255, nullable = false)
    private int shareRatio;
    @Column(length = 255, nullable = false)
    private int timeAvg;
    @Column(length = 255, nullable = false)
    private int routeNo;
    @Column(length = 255, nullable = false)
    private String updownTypeCode;
    @Column(length = 255, nullable = false)
    private String conzoneId;
    @Column(length = 255, nullable = false)
    private String conzoneName;
    @Column(length = 255, nullable = false)
    private String vdsId;
    @Column(length = 255, nullable = false)
    private int grade;

    public TransEntity(String routeName, String stdDate, int stdHour, int trafficAmout, int speed, int shareRatio, int timeAvg, int routeNo, String updownTypeCode, String conzoneId, String conzoneName, String vdsId, int grade) {
    }

    public TransDTO toDto(){
        return new TransDTO(routeName,stdDate,stdHour,trafficAmout,speed,shareRatio,timeAvg,routeNo,updownTypeCode,conzoneId,conzoneName,vdsId,grade);
    }
}
