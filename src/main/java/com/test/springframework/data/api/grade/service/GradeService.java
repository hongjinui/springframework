package com.test.springframework.data.api.grade.service;

import com.test.springframework.data.api.common.util.ApiCode;
import com.test.springframework.data.api.common.util.ResponseData;
import com.test.springframework.data.api.grade.dto.GradeDTO;
import org.springframework.stereotype.Service;

import java.net.http.HttpRequest;

@Service
public class GradeService {

    public ResponseData setGrade(GradeDTO param, HttpRequest httpRequest){
        ApiCode apiCode = null;
        ResponseData responseData = null;

        try{

        }catch (Exception e){

        }

        return responseData;
    }

}
