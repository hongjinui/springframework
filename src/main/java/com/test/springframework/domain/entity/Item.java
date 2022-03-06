package com.test.springframework.domain.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "TB_ITEM")
public class Item {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "ITM_NAME", length = 15, nullable = false)
    private String itmName;     // 아이팀(상품) 명

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CTG_ID", nullable = false)
    private Category category;  // 카테고
}
