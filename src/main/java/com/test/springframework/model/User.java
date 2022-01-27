package com.test.springframework.model;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Table(name = "TB_USER")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long usrSeq;

    private String usrId;

    private String usrPw;

    private String usrName;
}
