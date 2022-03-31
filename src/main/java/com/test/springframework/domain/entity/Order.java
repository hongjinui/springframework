package com.test.springframework.domain.entity;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "TB_ORDER")
public class Order {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MEM_ID")    // 주문자 정보
    private Member member;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "order")
    private List<OrderItem> orderItems;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)   // cascade 옵션 확인 -- 주문이 취소되면 배달도 취소되어야함
    @JoinColumn(name = "DVR_ID")
    private Delivery delivery;          // 배달 정보

    @Column(name = "ORD_TIME", updatable = false)
    private LocalDateTime ordTime;     // 주문 시간

    @Column(name = "ORD_COMPLETEYN", nullable = false, length = 1)
    private String ordCompleteyn;   // 주문 완료 여부

    @Column(name = "ORD_CANCELYN", nullable = false, length = 1)
    private String ordCancelyn;     // 주문 취소 여부

    private void addMember(Member member){
        this.member = member;
        member.getOrders().add(this);
    }
}
