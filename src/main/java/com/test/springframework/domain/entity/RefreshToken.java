package com.test.springframework.domain.entity;

import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Entity
@Table(name = "TB_REFRESHTOKEN")
public class RefreshToken {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int rtSeq;

    private long usrSeq;

    private String refreshToken;

    private String rtUseYn;

    // oracle 같은 경우 SYSTIMESTAMP로도 데이터 삽입 가능 개꿀
    private LocalDate registerDtm;



}
