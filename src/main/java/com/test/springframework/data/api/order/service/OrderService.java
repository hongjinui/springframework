package com.test.springframework.data.api.order.service;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.test.springframework.data.api.common.util.ApiCode;
import com.test.springframework.data.api.common.vo.ApiResponseVO;
import com.test.springframework.data.api.order.dto.OrderDTO;
import com.test.springframework.domain.repogitory.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final JPAQueryFactory jpaQueryFactory;
    private final OrderRepository orderRepository;


    public ApiResponseVO saveOrder(OrderDTO param, HttpServletRequest httpServletRequest) {

        ApiCode apiCode = ApiCode.ERROR;
        ApiResponseVO responseData = null;

        try{

        }
        catch (Exception e){

        }

        return responseData;

    }
}
