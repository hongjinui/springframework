package com.test.springframework.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "TB_REFRESHTOKEN")
public class RefreshToken {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long rtSeq;

    private long usrSeq;

    private String refreshToken;

    private String rtUseYn;

    // oracle 같은 경우 SYSTIMESTAMP로도 데이터 삽입 가능 개꿀
    private LocalDate registerDtm;



}
