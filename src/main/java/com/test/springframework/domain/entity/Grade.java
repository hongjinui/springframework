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
    @Column(name = "GRD_ID")
    private int grdId;

    @Column(name = "GRD_NAME", unique = true, nullable = false, length = 10)
//    @Enumerated(EnumType.STRING)
//    private GradeEnum grdName;     // 등급 명
    private String grdName;

    @Builder
//    public Grade(GradeEnum grdName){
//        this.grdName = grdName;
//    }
    public Grade(String grdName){
        this.grdName = grdName;
    }

    public void updateGrdName(String grdName){
        this.grdName = grdName;
    }
}
