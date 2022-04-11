package com.test.springframework.data.api.order;


import com.querydsl.jpa.impl.JPAQueryFactory;
import com.test.springframework.data.api.common.vo.ApiResponseVO;
import com.test.springframework.data.api.order.dto.OrderDTO;
import com.test.springframework.data.api.order.service.OrderService;
import com.test.springframework.domain.repogitory.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/order")
public class OrderController {

    private final OrderService orderService;

    @PostMapping(value = "/v1/saveOrder")
    public ResponseEntity<?> saveOrder(@RequestBody OrderDTO param, HttpServletRequest httpServletRequest){

        ApiResponseVO responseData = orderService.saveOrder(param, httpServletRequest);

        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }
}
