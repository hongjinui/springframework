package com.test.springframework.domain.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "TB_AUTHORITY")
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class Authority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int athSeq;

    private String usrSeq;

    private String authority;
}
