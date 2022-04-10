package com.test.springframework.data.api.member.vo;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.querydsl.core.annotations.QueryProjection;
import com.test.springframework.domain.entity.Grade;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MemberVO {

//    private long id;
    private String memName;     // 맴버 이름
    private String memEmail;    // 맴버 이메일
    private String memPhone;    // 맴버 핸드폰 번호
    private String memAddress;  // 맴버 주소
    private String memAge;      // 맴버 연령
    private String memSex;      // 맴버 성
    private String memUseyn;    // 맴버 탈퇴 여부
    private Grade grade;        // 맴버 등급
    private String grdName;

    @QueryProjection
    public MemberVO(String memName, String memEmail, String memPhone
            , String memAddress, String memAge, String memSex, String grdName
    ) {
//        this.id = id;
        this.memName = memName;
        this.memEmail = memEmail;
        this.memPhone = memPhone;
        this.memAddress = memAddress;
        this.memAge = memAge;
        this.memSex = memSex;
        this.grdName = grdName;
    }
}
