package com.test.springframework.data.api.order.service;

import com.test.springframework.data.api.common.util.ApiCode;
import com.test.springframework.data.api.common.vo.ApiResponseVO;
import com.test.springframework.data.api.order.dto.OrderDTO;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class OrderService {


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
