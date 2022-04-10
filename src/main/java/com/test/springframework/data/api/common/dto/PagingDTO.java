package com.test.springframework.data.api.common.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PagingDTO {

    private int pageNum;            // 페이지 번호
    private int pageCnt;            // 페이지 수
    private int cntPerPage;         // 페이지 당 수
}
