package com.test.springframework.domain.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "TB_USER")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int usrSeq;

    private String usrId;

//    private String usrPw;

    private String usrName;
}
