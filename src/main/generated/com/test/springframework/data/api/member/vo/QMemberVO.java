package com.test.springframework.data.api.member.vo;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.test.springframework.data.api.member.vo.QMemberVO is a Querydsl Projection type for MemberVO
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QMemberVO extends ConstructorExpression<MemberVO> {

    private static final long serialVersionUID = 1286754272L;

    public QMemberVO(com.querydsl.core.types.Expression<String> memName, com.querydsl.core.types.Expression<String> memEmail, com.querydsl.core.types.Expression<String> memPhone, com.querydsl.core.types.Expression<String> memAddress, com.querydsl.core.types.Expression<String> memAge, com.querydsl.core.types.Expression<String> memSex, com.querydsl.core.types.Expression<String> grdName) {
        super(MemberVO.class, new Class<?>[]{String.class, String.class, String.class, String.class, String.class, String.class, String.class}, memName, memEmail, memPhone, memAddress, memAge, memSex, grdName);
    }

}

