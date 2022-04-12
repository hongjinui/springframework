package com.test.springframework.data.api.item.service;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.test.springframework.data.api.common.util.ApiCode;
import com.test.springframework.data.api.common.util.ResponseData;
import com.test.springframework.data.api.common.vo.ApiResponseVO;
import com.test.springframework.data.api.item.dto.ItemDTO;
import com.test.springframework.domain.entity.Category;
import com.test.springframework.domain.entity.Item;
import com.test.springframework.domain.repogitory.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import static com.test.springframework.domain.entity.QCategory.*;
import static com.test.springframework.domain.entity.QItem.*;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final JPAQueryFactory jpaQueryFactory;
    private final ItemRepository itemRepository;

    @Transactional
    public ApiResponseVO saveItem(ItemDTO param, HttpServletRequest httpServletRequest){

        ApiCode apiCode = ApiCode.ERROR;
        ApiResponseVO responseData = null;

        try{

            // 카테고리
            Category resultCategory = jpaQueryFactory
                    .selectFrom(category)
                    .where(category.ctgId.eq(param.getCtgId()))
                    .fetchOne();

            // 아이템(상품) 저장
            Item item = Item.builder()
                    .itmName(param.getItmName())
                    .itmPrice(param.getItmPrice())
                    .category(resultCategory)
                    .build();

            itemRepository.save(item);

            apiCode = ApiCode.DATA_OK;
            responseData = ResponseData.apiResponse(HttpStatus.OK, item,apiCode);
        }
        catch (Exception e){
            responseData = ResponseData.apiResponse(HttpStatus.INTERNAL_SERVER_ERROR,null, apiCode);
        }

        return responseData;

    }

    @Transactional
    public ApiResponseVO updateItem(ItemDTO param, HttpServletRequest httpServletRequest) {

        ApiCode apiCode = ApiCode.ERROR;
        ApiResponseVO responseData = null;

        try{

            Category resultCategory = null;

            if(param.getCtgId() > 0){
                // 카테고리
                resultCategory = jpaQueryFactory
                        .selectFrom(category)
                        .where(category.ctgId.eq(param.getCtgId()))
                        .fetchOne();
            }

            Item resultItem = jpaQueryFactory
                    .selectFrom(item)
                    .where(item.itmId.eq(param.getItmId()))
                    .fetchOne();

            if( resultItem == null ) throw new Exception();
            resultItem.updateItmName(param.getItmName());
            if( resultCategory != null) resultItem.updateCtg(resultCategory);

            apiCode = ApiCode.DATA_OK;
            responseData = ResponseData.apiResponse(HttpStatus.OK, null,apiCode);
        }
        catch (Exception e){
            responseData = ResponseData.apiResponse(HttpStatus.INTERNAL_SERVER_ERROR,null, apiCode);
        }

        return responseData;

    }
}
