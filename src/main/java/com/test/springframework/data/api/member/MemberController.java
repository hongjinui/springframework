package com.test.springframework.data.api.member;


import com.test.springframework.data.api.common.vo.ApiResponseVO;
import com.test.springframework.data.api.member.dto.MemberDTO;
import com.test.springframework.data.api.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("api/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    /**
     * @param : MemberDTO
     * @return : ResponseEntity
     * @descrpition : 회원 가입
     */
    @PostMapping("v1/saveMember")
    public ResponseEntity<?> saveMember(@RequestBody MemberDTO param, HttpServletRequest httpServletRequest){

        ApiResponseVO responseData = memberService.saveMember(param, httpServletRequest);

        return new ResponseEntity<>(responseData,HttpStatus.OK);

    }

    /**
     * @param : MemberDTO
     * @return : ResponseEntity
     * @descrpition : 회원 수정
     */
    @PostMapping("v1/updateMember")
    public ResponseEntity<?> updateMember(@RequestBody MemberDTO param, HttpServletRequest httpServletRequest){

        ApiResponseVO responseData = memberService.updateMember(param, httpServletRequest);

        return new ResponseEntity<>(responseData,HttpStatus.OK);

    }

    /**
     * @param : MemberDTO
     * @return : ResponseEntity
     * @descrpition : 회원 정보 보기
     */
    @PostMapping("v1/selectMember")
    public ResponseEntity<?> selectMember(@RequestBody MemberDTO param, HttpServletRequest httpServletRequest){

        ApiResponseVO responseData = memberService.selectMember(param, httpServletRequest);

        return new ResponseEntity<>(responseData,HttpStatus.OK);

    }
}

