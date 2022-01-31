package com.test.springframework.data.api.user;

import com.test.springframework.data.api.common.vo.ApiResponseVO;
import com.test.springframework.data.api.user.dto.UserDTO;
import com.test.springframework.data.api.user.service.UserService;
import com.test.springframework.domain.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@RestController
@RequestMapping("api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping( value = "jpa/v1/getUser")
    public ResponseEntity<?> getUser(@RequestBody UserDTO param, HttpServletRequest request, HttpServletResponse response) throws Exception{

        ApiResponseVO responseData = userService.getUser(param, request);

        return new ResponseEntity<>(responseData, HttpStatus.OK);

    }

}
