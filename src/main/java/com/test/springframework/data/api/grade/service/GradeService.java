package com.test.springframework.data.api.grade.service;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.test.springframework.data.api.common.util.ApiCode;
import com.test.springframework.data.api.common.util.ResponseData;
import com.test.springframework.data.api.common.vo.ApiResponseVO;
import com.test.springframework.data.api.grade.dto.GradeDTO;
import com.test.springframework.domain.entity.Grade;
import com.test.springframework.domain.repogitory.GradeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

import static com.test.springframework.domain.entity.QGrade.*;

@Service
@RequiredArgsConstructor
public class GradeService {

    // Querydsl bean
    private final JPAQueryFactory jpaQueryFactory;
    // jpaRepository
    private final GradeRepository gradeRepository;

    @Transactional
    public ApiResponseVO saveGrade(GradeDTO param, HttpServletRequest httpServletRequest) {
        ApiCode apiCode = ApiCode.ERROR;
        ApiResponseVO responseData = null;

        try {

            // 엔터티 생성 단계
            Grade grade = Grade.builder()
                    .grdName(param.getGrdName())
                    .build();
            // persistenc 관리하에 있음
            // 트랜잭션 완료 후 실제 DB에 저장됨
            gradeRepository.save(grade);

            // persistenc 1차 캐시에서 관리하고 있기 때문에 실제로 셀렉트 쿼리를 동작하지 않는다.
            Grade resultGrade = gradeRepository.findByGrdName(param.getGrdName());

//            System.out.println(resultGrade);

            apiCode = ApiCode.DATA_OK;
            responseData = ResponseData.apiResponse(HttpStatus.OK, resultGrade, apiCode);
        } catch (Exception e) {
            e.printStackTrace();
            responseData = ResponseData.apiResponse(HttpStatus.INTERNAL_SERVER_ERROR, null, apiCode);
        }

        return responseData;
    }

    @Transactional
    public ApiResponseVO selectGrades(GradeDTO param, HttpServletRequest httpServletRequest) {
        ApiCode apiCode = ApiCode.ERROR;
        ApiResponseVO responseData = null;

        try {

            // TB_GRADE 테이블 셀렉트
            List<Grade> grades = jpaQueryFactory
                    .selectFrom(grade) // QGrade.grade 스테틱 임포트하였음
                    .orderBy(grade.grdId.asc())
                    .fetch();
            apiCode = ApiCode.DATA_OK;
            responseData = ResponseData.apiResponse(HttpStatus.OK, grades, apiCode);
        } catch (Exception e) {
            e.printStackTrace();
            responseData = ResponseData.apiResponse(HttpStatus.INTERNAL_SERVER_ERROR, null, apiCode);
        }

        return responseData;
    }

    @Transactional
    public ApiResponseVO updateGrade(GradeDTO param, HttpServletRequest httpServletRequest) {
        ApiCode apiCode = ApiCode.ERROR;
        ApiResponseVO responseData = null;

        try {

            // getById() : 프록시 객체 생성 메소드 --> DB 셀렉트 쿼리를 실행하지 않음
            // 트랜잭션 종료 후 DB에 쿼리를 실행시켜 데이터가 없으면 EntityNotFoundException 발생
            // Grade resultGrade = gradeRepository.getById(param.getId());

            // findByIdI() : DB에 셀렉트 쿼리를 실행하여 데이터를 가져옴
            // 셀렉트 쿼리를 실행 시켜 데이터가 없으면 IllegalArgumentException 발생
            Optional<Grade> resultGrade = gradeRepository.findById(param.getId());

            // 등급명 수정
            resultGrade.ifPresent(value -> value.updateGrdName(param.getUpdateGrdName()));

            apiCode = ApiCode.DATA_OK;
            responseData = ResponseData.apiResponse(HttpStatus.OK, resultGrade, apiCode);
        } catch (Exception e) {
            e.printStackTrace();
            responseData = ResponseData.apiResponse(HttpStatus.INTERNAL_SERVER_ERROR, null, apiCode);
        }

        return responseData;
    }
}
