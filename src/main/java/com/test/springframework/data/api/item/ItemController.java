package com.test.springframework.data.api.item;

import com.test.springframework.data.api.common.vo.ApiResponseVO;
import com.test.springframework.data.api.item.dto.ItemDTO;
import com.test.springframework.data.api.item.service.ItemService;
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
@RequestMapping("api/item")
public class ItemController {

    private final ItemService itemService;

    /**
     * @param : MemberDTO
     * @return : ResponseEntity
     * @descrpition : 아이템(상품) 저장
     */
    @PostMapping(value = "/v1/saveItem")
    public ResponseEntity<?> saveItem(@RequestBody ItemDTO param, HttpServletRequest httpServletRequest){
        ApiResponseVO responseData = itemService.saveItem(param,httpServletRequest);

        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }

    /**
     * @param : MemberDTO
     * @return : ResponseEntity
     * @descrpition : 아이템(상품) 수정
     */
    @PostMapping(value = "/v1/updateItem")
    public ResponseEntity<?> updateItem(@RequestBody ItemDTO param, HttpServletRequest httpServletRequest){
        ApiResponseVO responseData = itemService.updateItem(param,httpServletRequest);

        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }


}
