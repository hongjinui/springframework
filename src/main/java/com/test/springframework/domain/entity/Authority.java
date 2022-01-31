package com.test.springframework.domain.entity;


import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "TB_AUTHORITY")
public class Authority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int athSeq;

    private String usrSeq;

    private String authority;
}
