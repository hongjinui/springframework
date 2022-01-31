package com.test.springframework.data.api.user.dto;

import lombok.*;

@Data
//@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class UserDTO {

    private int usrSeq;
    private String usrId;
    private String usrPw;
    private String usrName;

}
