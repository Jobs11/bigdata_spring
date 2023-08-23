package com.example.crops.service;

import com.example.crops.domain.MemberVO;


public interface MemberService {
    public MemberVO getMemberById(String userId);

    // 회원 정보 등록
    public void insertMember(MemberVO member);

    public MemberVO loginMember(String userId, String password);
}
