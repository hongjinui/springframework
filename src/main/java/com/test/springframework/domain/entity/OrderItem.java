package com.test.springframework.domain.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "TB_ORDERITEM")
public class OrderItem {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ORD_ID", nullable = false)
    private Order order;        // 주문 정보

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ITM_ID", nullable = false)
    private Item item;          // 아이템(상품) 정보

}
