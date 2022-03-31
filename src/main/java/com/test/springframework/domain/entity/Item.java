package com.test.springframework.domain.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "TB_ITEM")
public class Item {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "ITM_NAME", length = 15, nullable = false)
    private String itmName;     // 아이템(상품) 명

    @Column(name = "ITM_PRICE", length = 10, nullable = false)
    private int itmPrice;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CTG_ID", nullable = false)
    private Category category;  // 카테고리

    /**
     * Item과 OrderItem을 양방향 매핑을 해야하나?
     * 해야지 상품을 검색해서 얼마나 팔렸나 볼 수 있지 관리자에게는 필요 할 수 있지.
     * */

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "item")
    private List<OrderItem> orderItems;
}
