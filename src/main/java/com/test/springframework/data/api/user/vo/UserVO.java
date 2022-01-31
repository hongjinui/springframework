package com.test.springframework.data.api.user.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserVO {

    private int usrSeq;
    private String usrId;
    private String usrName;

}
