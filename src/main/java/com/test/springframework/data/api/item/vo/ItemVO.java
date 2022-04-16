package com.test.springframework.data.api.item.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ItemVO {

    private int itmId;
    private String itmName;
    private int itmPrice;
    private String ctgName;
//    private Category category;
//    private List<OrderItem> orderItems;

    @QueryProjection
    public ItemVO(int itmId, String itmName, int itmPrice, String ctgName){
        this.itmId = itmId;
        this.itmName = itmName;
        this.itmPrice = itmPrice;
        this.ctgName = ctgName;
    }

}
