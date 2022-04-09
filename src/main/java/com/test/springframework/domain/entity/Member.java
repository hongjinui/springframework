package com.test.springframework.domain.entity;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)  // 왜 PROTECTED로 하는지 정리하자 - Builder pattern?
@Table(name = "TB_MEMBER")
//@ToString(exclude = {"orders", "grade"})   // orders,grade 제외시키는 이유 : 지연 로딩인데 @ToString 때문에 쿼리를 실행시키기 때문에
public class Member{

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "MEM_NAME", length = 20, nullable = false)
    private String memName;     // 맴버 이름

    @Column(name = "MEM_EMAIL", length = 30, unique = true, nullable = false)
    private String memEmail;    // 맴버 이메일

    @Column(name = "MEM_PHONE", length = 11, unique = true, nullable = false)
    private String memPhone;    // 맴버 핸드폰 번호

    @Column(name = "MEM_ADDRESS", nullable = false)
    private String memAddress;  // 맴버 주소

    @Column(name = "MEM_AGE")
    private String memAge;      // 맴버 연령

    @Column(name = "MEM_SEX")
    private String memSex;      // 맴버 성

//    @Column(name = "MEM_CREDITCARD", length = 16)
//    private String memCreditCard;   // 신용카드

    @Column(name = "MEM_USEYN", nullable = false)
    private String memUseyn;        // 맴버 탈퇴 여부

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "member")  // LAZY 권장 사항, mappedBy 개념 중요
    private List<Order> orders; // 맴버의 주문 목록

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "GRD_ID")
    private Grade grade;        // 맴버 등급

    @Builder    // 필수 값만 빌더메소드에 추가
    public Member(String memName, String memEmail, String memPhone, String memAddress,String memUseyn, Grade grade){
        this.memName = memName;
        this.memEmail = memEmail;
        this.memPhone = memPhone;
        this.memAddress = memAddress;
        this.memUseyn = memUseyn;
        this.grade = grade;
    }

    public void updateMemName(String memName){
        this.memName = memName;
    }

    public void updateMemEmail(String memEmail){
        this.memEmail = memEmail;
    }

    public void updateMemPhone(String memPhone){
        this.memPhone = memPhone;
    }

    public void updateAddress(String memAddress){
        this.memAddress = memAddress;
    }

}
