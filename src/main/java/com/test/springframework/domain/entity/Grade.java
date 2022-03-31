package com.test.springframework.domain.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "TB_GRADE")
public class Grade {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "GRD_NAME", unique = true, nullable = false, length = 10)
    @Enumerated(EnumType.STRING)
    private String grdName;     // 등급 명

    @Builder
    public Grade(String grdName){
        this.grdName = grdName;
    }
}
