package com.test.springframework.data.api.member.service;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.test.springframework.data.api.common.util.ApiCode;
import com.test.springframework.data.api.common.util.ResponseData;
import com.test.springframework.data.api.common.vo.ApiResponseVO;
import com.test.springframework.data.api.member.dto.MemberDTO;
import com.test.springframework.data.api.member.vo.QMemberVO;
import com.test.springframework.domain.entity.Grade;
import com.test.springframework.domain.entity.Member;
import com.test.springframework.data.api.member.vo.MemberVO;
import com.test.springframework.domain.repogitory.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import java.util.List;

import static com.test.springframework.domain.entity.QMember.*;
import static com.test.springframework.domain.entity.QGrade.*;
import static org.springframework.util.StringUtils.hasText;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final JPAQueryFactory jpaQueryFactory;
    private final MemberRepository memberRepository;

    @Transactional
    public ApiResponseVO saveMember(MemberDTO param, HttpServletRequest httpServletRequest) {

        ApiCode apiCode = ApiCode.ERROR;
        ApiResponseVO responseData = null;

        try {

            // 첫 가입시 BRONZE 등급으로 저장
            Grade resultGrade = jpaQueryFactory.selectFrom(grade)
                    .where(grade.grdId.eq(2))
                    .fetchOne();

            // 회원 가입 필수 데이터 + 등급
            Member member = Member.builder()
                    .memName(param.getMemName())
                    .memEmail(param.getMemEmail())
                    .memPhone(param.getMemPhone())
                    .memAddress(param.getMemAddress())
                    .memUseyn("Y")
                    .grade(resultGrade)
                    .build();

            // 회원 가입
            memberRepository.save(member);

            apiCode = ApiCode.DATA_OK;
            responseData = ResponseData.apiResponse(HttpStatus.OK, member, apiCode);
        } catch (Exception e) {
            responseData = ResponseData.apiResponse(HttpStatus.INTERNAL_SERVER_ERROR, null, apiCode);
        }

        return responseData;
    }

    @Transactional
    public ApiResponseVO updateMember(MemberDTO param, HttpServletRequest httpServletRequest) {

        ApiCode apiCode = ApiCode.ERROR;
        ApiResponseVO responseData = null;

        try {
            Member resultMember = jpaQueryFactory
                    .selectFrom(member)
                    .where(member.memEmail.eq(param.getMemEmail()))
                    .fetchOne();

            if (resultMember == null) throw new Exception();
            resultMember.updateMemName(param.getMemName());     // 회원 이름
//            resultMember.updateMemEmail(param.getMemEmail());   // 회원 이메일
            resultMember.updateMemPhone(param.getMemPhone());   // 회원 휴대폰 번호
            resultMember.updateAddress(param.getMemAddress());  // 회원 주소

            apiCode = ApiCode.DATA_OK;
            responseData = ResponseData.apiResponse(HttpStatus.OK, null, apiCode);

        } catch (Exception e) {
            responseData = ResponseData.apiResponse(HttpStatus.OK, null, apiCode);
        }

        return responseData;
    }

    @Transactional
    public ApiResponseVO selectMember(MemberDTO param, HttpServletRequest httpServletRequest) {

        ApiCode apiCode = ApiCode.ERROR;
        ApiResponseVO responseData = null;

        try {
            MemberVO resultMember = jpaQueryFactory
                    .select(new QMemberVO(
//                            Expressions.asNumber(param.getId()).as("memId"),
                            member.memName
                            , member.memEmail
                            , member.memPhone
                            , member.memAddress
                            , member.memAge
                            , member.memSex
                            , grade.grdName
                    ))
                    .from(member)
                    .innerJoin(member.grade, grade)
                    .where(
                            memIdEq(param.getMemId())           // id(pk)가 같은 조건 -- 값이 없으면 null
                            , memEmailEq(param.getMemEmail())   // 이메일 같은 조건
                            , memPhoneEq(param.getMemPhone())   // 휴대폰 번호 같은 조건
                    )
                    .fetchOne();

            apiCode = ApiCode.DATA_OK;
            responseData = ResponseData.apiResponse(HttpStatus.OK, resultMember, apiCode);
        } catch (Exception e) {
            e.printStackTrace();
            responseData = ResponseData.apiResponse(HttpStatus.INTERNAL_SERVER_ERROR, null, apiCode);
        }
        return responseData;

    }

    @Transactional
    public ApiResponseVO selectMembersPage(MemberDTO param, HttpServletRequest httpServletRequest) {

        ApiCode apiCode = ApiCode.ERROR;
        ApiResponseVO responseData = null;

        try {

            initPage(param);

            List<MemberVO> members = jpaQueryFactory
                    .select(new QMemberVO(
//                            Expressions.asNumber(param.getId()).as("memId"),
                            member.memName
                            , member.memEmail
                            , member.memPhone
                            , member.memAddress
                            , member.memAge
                            , member.memSex
                            , grade.grdName
                    ))
                    .from(member)
                    .innerJoin(member.grade, grade)     // grade inner join
                    .where(
                            memIdLt(param.getLastMemId())
                    )
                    .orderBy(member.memId.desc())
//                    .offset(param.getPageNum())     // 페이지 번호
                    .limit(param.getCntPerPage())   // 페이지 당 수
                    .fetch();

            apiCode = ApiCode.DATA_OK;
            responseData = ResponseData.apiResponse(HttpStatus.OK, members, apiCode);

        } catch (Exception e) {
            responseData = ResponseData.apiResponse(HttpStatus.INTERNAL_SERVER_ERROR, null, apiCode);
        }

        return responseData;


    }

    // 페이지 초기화
    private void initPage(MemberDTO param) {

        if (param.getLastMemId() == 0) param.setLastMemId(0);
        if (param.getCntPerPage() == 0) param.setCntPerPage(10);

    }

    // 회원 id(pk)
    private BooleanExpression memIdEq(Long memId) {
        return (memId != null && memId != 0) ? member.memId.eq(memId) : null;
    }

    // 회원 명
    private BooleanExpression memNameEq(String memName) {
        return hasText(memName) ? member.memName.eq(memName) : null;
    }

    // 회원 이메일
    private BooleanExpression memEmailEq(String memEmail) {
        return hasText(memEmail) ? member.memEmail.eq(memEmail) : null;
    }

    // 회원 핸드폰 번호
    private BooleanExpression memPhoneEq(String memPhone) {
        return hasText(memPhone) ? member.memPhone.eq(memPhone) : null;
    }

    // 회원 id 이하
    private BooleanExpression memIdLt(Integer lastMemId) {
        return (lastMemId != null && lastMemId != 0) ? member.memId.lt(lastMemId) : null;
    }


}
