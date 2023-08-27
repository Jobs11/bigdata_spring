package com.example.crops.service;

import com.example.crops.domain.MemberVO;


public interface MemberService{
    MemberVO getMemberById(String username);

    // 회원 정보 등록
    void insertMember(MemberVO member);


}
