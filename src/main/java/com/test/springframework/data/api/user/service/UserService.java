package com.test.springframework.data.api.user.service;


import com.test.springframework.data.api.common.util.ApiCode;
import com.test.springframework.data.api.common.util.ResponseData;
import com.test.springframework.data.api.common.vo.ApiResponseVO;
import com.test.springframework.data.api.user.dto.UserDTO;
import com.test.springframework.data.api.user.vo.UserVO;
import com.test.springframework.domain.entity.User;
import com.test.springframework.domain.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

@Slf4j
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public ApiResponseVO getUser(UserDTO param, HttpServletRequest request){

        ApiResponseVO responseData = null;
        ApiCode apiCode = ApiCode.ERROR;
        try{

            int usrSeq = param.getUsrSeq();

            User user = userRepository.getById(usrSeq);

            HashMap<String, Object> data = new HashMap<>();
            data.put("user", user);

            apiCode = ApiCode.DATA_OK;
            responseData = ResponseData.apiResponse(HttpStatus.OK,data,apiCode);

        }catch (Exception e){
            e.printStackTrace();
            responseData = ResponseData.apiResponse(HttpStatus.INTERNAL_SERVER_ERROR,null,apiCode);
        }

        return responseData;
    }
}
