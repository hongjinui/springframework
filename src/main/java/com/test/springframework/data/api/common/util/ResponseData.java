package com.test.springframework.data.api.common.util;

import com.test.springframework.common.DateUtil;
import com.test.springframework.data.api.common.vo.ApiResponseVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import java.time.LocalDateTime;

@Slf4j
public class ResponseData {

    public static ApiResponseVO apiResponse(HttpStatus httpStatus, Object data, ApiCode apiCode){

        ApiResponseVO responseData = ApiResponseVO.builder()
                .status(httpStatus.value())
                .code(apiCode.getCode())
                .message(apiCode.getMessage())
                .data(data)
                .date(DateUtil.getLocalDateToString(LocalDateTime.now()))
                .httpStatus(httpStatus)
                .build();

        log.debug(responseData.toString());

        return responseData;
    }
}
