package com.test.springframework.data.api.delivery;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

    /**
     * @apiNote 배달 자체를 따로 저장한다거나 취소하는 일이 있을까?
     * order api에 추가해야 할 것같은데?
     * 한 트랜잭션으로 처리해야할 듯
     *
     *
     *
     *
     * */

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/delivery")
public class DeliveryController {


}
