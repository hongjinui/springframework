package com.test.springframework.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "TB_USER")
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int usrSeq;

    private String usrId;

//    private String usrPw;

    private String usrName;
}
