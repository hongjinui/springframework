package com.test.springframework.domain.entity;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "TB_CATEGORY")
public class Category {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "CTG_NAME", nullable = false)
    private String ctgName;     // 카테고리 명 -- 한식,중식,일식,분식 등
}
