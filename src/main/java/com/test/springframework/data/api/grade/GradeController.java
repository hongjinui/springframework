package com.test.springframework.data.api.grade;

import com.test.springframework.data.api.common.util.ApiCode;
import com.test.springframework.data.api.common.util.ResponseData;
import com.test.springframework.data.api.common.vo.ApiResponseVO;
import com.test.springframework.data.api.grade.dto.GradeDTO;
import com.test.springframework.data.api.grade.service.GradeService;
import com.test.springframework.domain.entity.Grade;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.net.http.HttpRequest;

@RestController
@RequestMapping("api/grade")
public class GradeController {

    @Autowired
    GradeService gradeService;

    /**
     *
     * @descrpition : 등급 저장
     * @param  : GradeDTO
     * @return : ResponseEntity
     *
     * */
    @PostMapping("v1/saveGrade")
    public ResponseEntity<?> saveGrade(@RequestBody GradeDTO param, HttpServletRequest httpRequest){

        ApiResponseVO responseData = gradeService.saveGrade(param, httpRequest);

        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }

    /**
     *
     * @descrpition : 등급 조회
     * @param  : GradeDTO
     * @return : ResponseEntity
     *
     * */
    @PostMapping("v1/selectGrades")
    public ResponseEntity<?> selectGrades(@RequestBody GradeDTO param, HttpServletRequest httpRequest){

        ApiResponseVO responseData = gradeService.selectGrades(param, httpRequest);

        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }
}
