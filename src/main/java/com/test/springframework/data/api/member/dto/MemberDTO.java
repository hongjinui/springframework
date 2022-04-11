package com.test.springframework.data.api.member.dto;

import lombok.*;

@Getter
@Setter
public class MemberDTO {

    private long memId;
    private String memName;
    private String memEmail;
    private String memPhone;
    private String memAddress;
    private String memAge;
    private String memSex;
    private String memUseyn;

    private int lastMemId;
    private int cntPerPage;
}
