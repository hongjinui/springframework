package com.test.springframework.data.api.item.vo;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.test.springframework.data.api.item.vo.QItemVO is a Querydsl Projection type for ItemVO
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QItemVO extends ConstructorExpression<ItemVO> {

    private static final long serialVersionUID = 1337183634L;

    public QItemVO(com.querydsl.core.types.Expression<Integer> itmId, com.querydsl.core.types.Expression<String> itmName, com.querydsl.core.types.Expression<Integer> itmPrice, com.querydsl.core.types.Expression<String> ctgName) {
        super(ItemVO.class, new Class<?>[]{int.class, String.class, int.class, String.class}, itmId, itmName, itmPrice, ctgName);
    }

}

