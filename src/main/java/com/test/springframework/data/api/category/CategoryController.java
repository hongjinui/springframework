package com.test.springframework.data.api.category;


import com.test.springframework.data.api.category.dto.CategoryDTO;
import com.test.springframework.data.api.category.service.CategoryService;
import com.test.springframework.data.api.common.vo.ApiResponseVO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("api/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    /**
     *
     * @descrpition : 카테고리 저장
     * @param  : CategoryDTO
     * @return : ResponseEntity
     *
     * */

    @PostMapping("v1/saveCategory")
    public ResponseEntity<?> saveCategory(@RequestBody CategoryDTO param, HttpServletRequest httpServletRequest){

        ApiResponseVO responseData = categoryService.saveCategory(param, httpServletRequest);

        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }

    /**
     *
     * @descrpition : 카테고리 조회
     * @param  : CategoryDTO
     * @return : ResponseEntity
     *
     * */

    @PostMapping("v1/selectCategories")
    public ResponseEntity<?> selectCategories(@RequestBody CategoryDTO param, HttpServletRequest httpServletRequest){

        ApiResponseVO responseData = categoryService.selectCategories(param, httpServletRequest);

        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }

    /**
     *
     * @descrpition : 카테로기 수정
     * @param  : CategoryDTO
     * @return : ResponseEntity
     *
     * */

    @PostMapping("v1/updateCategory")
    public ResponseEntity<?> updateCategory(@RequestBody CategoryDTO param, HttpServletRequest httpServletRequest){

        ApiResponseVO responseData = categoryService.updateCategory(param, httpServletRequest);

        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }

}
