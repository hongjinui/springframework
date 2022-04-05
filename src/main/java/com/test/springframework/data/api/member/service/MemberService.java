package com.test.springframework.data.api.member.service;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.test.springframework.data.api.common.util.ApiCode;
import com.test.springframework.data.api.common.util.ResponseData;
import com.test.springframework.data.api.common.vo.ApiResponseVO;
import com.test.springframework.data.api.member.dto.MemberDTO;
import com.test.springframework.domain.entity.Grade;
import com.test.springframework.domain.entity.Member;
import com.test.springframework.domain.repogitory.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import static com.test.springframework.domain.entity.QGrade.*;

@Service
@RequiredArgsConstructor
public class MemberService {
    
    private final JPAQueryFactory jpaQueryFactory;
    private final MemberRepository memberRepository;

    @Transactional
    public ApiResponseVO saveMember(MemberDTO param, HttpServletRequest httpServletRequest) {

        ApiCode apiCode = ApiCode.ERROR;
        ApiResponseVO responseData = null;

        try{

            // 첫 가입시 BRONZE 등급으로 저장
            Grade resultGrade = jpaQueryFactory.selectFrom(grade)
                    .where(grade.id.eq(2))
                    .fetchOne();

            // 회원 가입 필수 데이터 + 등급
            Member member = Member.builder()
                    .memName(param.getMemName())
                    .memEmail(param.getMemEmail())
                    .memPhone(param.getMemPhone())
                    .memAddress(param.getMemAddress())
                    .grade(resultGrade)
                    .build();

            // 회원 가입
            memberRepository.save(member);

            System.out.println(member.toString());

            apiCode = ApiCode.DATA_OK;
            responseData = ResponseData.apiResponse(HttpStatus.OK, member, apiCode);
        }
        catch (Exception e){
            responseData = ResponseData.apiResponse(HttpStatus.INTERNAL_SERVER_ERROR, null, apiCode);
        }

        return responseData;
    }
}
