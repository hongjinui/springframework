package com.test.springframework.data.api.grade;

import com.test.springframework.data.api.common.util.ApiCode;
import com.test.springframework.data.api.common.util.ResponseData;
import com.test.springframework.data.api.grade.dto.GradeDTO;
import com.test.springframework.data.api.grade.service.GradeService;
import com.test.springframework.domain.entity.Grade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.http.HttpRequest;

@RestController
@RequestMapping("api/grade")
public class GradeController {

    @Autowired
    GradeService gradeService;

    /**
     *
     * @param
     * @return
     *
     * */

    @PostMapping("v1/setGrade")
    public ResponseEntity<?> setGrade(@RequestBody GradeDTO param, HttpRequest httpRequest){

        ResponseData responseData = gradeService.setGrade(param, httpRequest);

        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }
}
