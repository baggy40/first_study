package com.example.study.entity;

import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name= "tbl_memo")
@ToString
public class Meme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mno;
}
