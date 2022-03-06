package com.test.springframework.domain.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "TB_DELIVERY")
public class Delivery {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "DVR_COMPLETEYN", nullable = false, length = 1)
    private String dvrCompleteyn; // 배달 완료 여부

    @Column(name = "DVR_CANCELYN", nullable = false, length = 1)
    private String dvrCancelyn;   // 배달 취소 여부

//    @Column(name = "DVR_DRIVER", nullable = false)
//    private String dvrDriver;    // 배달 기사

    @Column(name = "DVR_COMPLETETIME", nullable = false)
    private LocalDateTime dvrCompletetime;  // 배달 완료 시간

}
