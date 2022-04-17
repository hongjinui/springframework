package com.test.springframework.data.api.order.service;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.test.springframework.data.api.common.util.ApiCode;
import com.test.springframework.data.api.common.vo.ApiResponseVO;
import com.test.springframework.data.api.order.dto.OrderDTO;
import com.test.springframework.domain.entity.Order;
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
            /**
             * 1. 주문 정보 저장 후 주문 정보 조회
             * 2. 조회한 주문 정보를 기반으로 배발 정보도 저장 -> cascade 옵션으로 한 번에 저장하자
             *
             * */

//            Order order = Order

        }
        catch (Exception e){

        }

        return responseData;

    }
}
