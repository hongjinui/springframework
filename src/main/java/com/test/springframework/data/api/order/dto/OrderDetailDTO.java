package com.test.springframework.data.api.order.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderDetailDTO {

    private int itmId;
    private int itmPrice;
    private String itmName;
    private String ctgName;

}
