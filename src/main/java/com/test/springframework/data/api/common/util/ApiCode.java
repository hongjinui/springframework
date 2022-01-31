package com.test.springframework.data.api.common.util;

import lombok.Getter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@Getter
public enum ApiCode {

    DATA_OK(1000, "OK")
    , ERROR(3000, "오류 발생")
    ;

    private int code;
    private String message;

    ApiCode(int code, String message){
        this.code = code;
        this.message = message;
    }

    @Override
    public String toString(){
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }

}
