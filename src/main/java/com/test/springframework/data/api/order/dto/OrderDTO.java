package com.test.springframework.data.api.order.dto;

import com.test.springframework.domain.entity.Member;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrderDTO {

    private long id;
    private int memId;
    private List<OrderDetailDTO> orderDetails;

}
