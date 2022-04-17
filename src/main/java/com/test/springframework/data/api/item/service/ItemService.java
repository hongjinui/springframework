package com.test.springframework.data.api.item.service;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.test.springframework.data.api.common.util.ApiCode;
import com.test.springframework.data.api.common.util.ResponseData;
import com.test.springframework.data.api.common.vo.ApiResponseVO;
import com.test.springframework.data.api.item.dto.ItemDTO;
import com.test.springframework.data.api.item.vo.ItemVO;
import com.test.springframework.data.api.item.vo.QItemVO;
import com.test.springframework.domain.entity.Category;
import com.test.springframework.domain.entity.Item;
import com.test.springframework.domain.repogitory.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import java.util.List;

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

            Item resultItem = itemRepository.save(item);

            apiCode = ApiCode.DATA_OK;
            responseData = ResponseData.apiResponse(HttpStatus.OK, resultItem,apiCode);
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

            Item resultItem = jpaQueryFactory
                    .selectFrom(item)
                    .where(item.itmId.eq(param.getItmId()))
                    .fetchOne();

            if( resultItem == null ) throw new Exception();

            updateData(resultItem, param);

            apiCode = ApiCode.DATA_OK;
            responseData = ResponseData.apiResponse(HttpStatus.OK, null,apiCode);
        }
        catch (Exception e){
            responseData = ResponseData.apiResponse(HttpStatus.INTERNAL_SERVER_ERROR,null, apiCode);
        }

        return responseData;

    }

    private void updateData(Item resultItem, ItemDTO param){

        // 아이템(상품) 명
        if(!StringUtils.isEmpty(param.getItmName()) ){
            resultItem.updateItmName(param.getItmName());
        }

        // 아이템(상품) 가격
        if( param.getItmPrice() > 0 ){
            resultItem.updateItmPrice(param.getItmPrice());
        }

        // 아이템(상품) 카테고리
        if( param.getCtgId() > 0 ){
            // 카테고리
            Category resultCategory = jpaQueryFactory
                    .selectFrom(category)
                    .where(category.ctgId.eq(param.getCtgId()))
                    .fetchOne();

            if( resultCategory != null) resultItem.updateCtg(resultCategory);
        }

    }

    @Transactional
    public ApiResponseVO selectItems(ItemDTO param, HttpServletRequest httpServletRequest) {

        ApiCode apiCode = ApiCode.ERROR;
        ApiResponseVO responseData = null;

        try{

//            List<Item> resultItems = jpaQueryFactory
//                    .selectFrom(item)
//                    .orderBy(item.itmId.asc())
//                    .fetch();

            List<ItemVO> items = jpaQueryFactory
                    .select(new QItemVO(
                            item.itmId
                            , item.itmName
                            , item.itmPrice
                            , category.ctgName
                    ))
                    .from(item)
                    .innerJoin(item.category, category)
                    .orderBy(item.itmId.asc())
                    .fetch();

            apiCode = ApiCode.DATA_OK;
            responseData = ResponseData.apiResponse(HttpStatus.OK, items, apiCode);

        }
        catch (Exception e){
            e.printStackTrace();
            responseData = ResponseData.apiResponse(HttpStatus.INTERNAL_SERVER_ERROR, null, apiCode);
        }

        return responseData;


    }
}
