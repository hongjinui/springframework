package com.test.springframework.data.api.grade.service;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.test.springframework.data.api.common.util.ApiCode;
import com.test.springframework.data.api.common.util.ResponseData;
import com.test.springframework.data.api.common.vo.ApiResponseVO;
import com.test.springframework.data.api.grade.dto.GradeDTO;
import com.test.springframework.domain.entity.Grade;
import com.test.springframework.domain.entity.QGrade;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import java.util.List;

import static com.test.springframework.domain.entity.QGrade.*;

@Service
@RequiredArgsConstructor
public class GradeService {

    JPAQueryFactory jpaQueryFactory;

    @Transactional
    public ApiResponseVO saveGrade(GradeDTO param, HttpServletRequest httpRequest) {
        ApiCode apiCode = ApiCode.ERROR;
        ApiResponseVO responseData = null;

        try {

            QGrade grade = QGrade.grade;
//            Grade grade = Grade.builder()
//                    .grdName(param.getGrdName())
//                    .build();

            long result = jpaQueryFactory.insert(grade)
                    .columns(grade.grdName)
                    .values(param.getGrdName())
                    .execute();
            apiCode = ApiCode.DATA_OK;
            responseData = ResponseData.apiResponse(HttpStatus.OK, null, apiCode );
        } catch (Exception e) {
            responseData = ResponseData.apiResponse(HttpStatus.INTERNAL_SERVER_ERROR, null, apiCode);
        }

        return responseData;
    }

    public ApiResponseVO selectGrades(GradeDTO param, HttpServletRequest httpRequest) {
        ApiCode apiCode = ApiCode.ERROR;
        ApiResponseVO responseData = null;

        try {

            List<Grade> grades = jpaQueryFactory
                    .selectFrom(grade)
                    .fetch();

            apiCode = ApiCode.DATA_OK;
            responseData = ResponseData.apiResponse(HttpStatus.OK, grades, apiCode );
        } catch (Exception e) {
            responseData = ResponseData.apiResponse(HttpStatus.INTERNAL_SERVER_ERROR, null, apiCode);
        }

        return responseData;
    }
}
