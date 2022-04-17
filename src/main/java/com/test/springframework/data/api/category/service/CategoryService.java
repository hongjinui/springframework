package com.test.springframework.data.api.category.service;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.test.springframework.data.api.category.dto.CategoryDTO;
import com.test.springframework.data.api.common.util.ApiCode;
import com.test.springframework.data.api.common.util.ResponseData;
import com.test.springframework.data.api.common.vo.ApiResponseVO;
import com.test.springframework.domain.entity.Category;
import com.test.springframework.domain.repogitory.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import java.util.List;

import static com.test.springframework.domain.entity.QCategory.*;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final JPAQueryFactory jpaQueryFactory;
    private final CategoryRepository categoryRepository;

    @Transactional
    public ApiResponseVO saveCategory(CategoryDTO param, HttpServletRequest httpServletRequest){

        ApiCode apiCode = ApiCode.ERROR;
        ApiResponseVO responseData = null;

        try{

            Category category = Category.builder()
                    .ctgName(param.getCtgName())
                    .build();

            Category resultCategory = categoryRepository.save(category);

            apiCode = ApiCode.DATA_OK;
            responseData = ResponseData.apiResponse(HttpStatus.OK, resultCategory, apiCode);
        }
        catch (Exception e){
            responseData = ResponseData.apiResponse(HttpStatus.INTERNAL_SERVER_ERROR, null, apiCode);
        }

        return responseData;

    }

    @Transactional
    public ApiResponseVO updateCategory(CategoryDTO param, HttpServletRequest httpServletRequest) {

        ApiCode apiCode = ApiCode.ERROR;
        ApiResponseVO responseData = null;

        try{

            // 프록시 객체 생성.. 트랜잭션이 끝난 후 쿼리 실행
            Category resultCategory = categoryRepository.getById(param.getId());

            resultCategory.updateCtgName(param.getUpdateCtgName());

            apiCode = ApiCode.DATA_OK;
            responseData = ResponseData.apiResponse(HttpStatus.OK, null, apiCode);
        }
        catch (Exception e){
            responseData = ResponseData.apiResponse(HttpStatus.INTERNAL_SERVER_ERROR, null, apiCode);
        }

        return responseData;

    }

    @Transactional
    public ApiResponseVO selectCategories(CategoryDTO param, HttpServletRequest httpServletRequest) {

        ApiCode apiCode = ApiCode.ERROR;
        ApiResponseVO responseData = null;

        try{
            List<Category> categories = jpaQueryFactory
                    .selectFrom(category)
                    .orderBy(category.ctgId.asc())
                    .fetch();

            apiCode = ApiCode.DATA_OK;
            responseData = ResponseData.apiResponse(HttpStatus.OK, categories, apiCode);
        }
        catch (Exception e){
            responseData = ResponseData.apiResponse(HttpStatus.INTERNAL_SERVER_ERROR, null, apiCode);
        }

        return responseData;

    }
}
