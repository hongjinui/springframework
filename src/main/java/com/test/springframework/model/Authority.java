package com.test.springframework.model;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "TB_AUTHORITY")
public class Authority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long athSeq;

    private String usrSeq;

    private String authority;
}
