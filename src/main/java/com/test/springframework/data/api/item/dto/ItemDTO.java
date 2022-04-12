package com.test.springframework.data.api.item.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemDTO {

    private int itmId;          // 아이템(상품) id
    private String itmName;    // 아이템(상품) 명
    private int itmPrice;       // 아이템(상품) 가격
    private int ctgId;          // 카테고리 id

}
