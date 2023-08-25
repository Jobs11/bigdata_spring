package com.example.crops.service;

import com.example.crops.domain.MemberVO;
import org.springframework.security.core.userdetails.UserDetailsService;


public interface MemberService extends UserDetailsService {
    MemberVO getMemberById(String userId);

    // 회원 정보 등록
    void insertMember(MemberVO member);


}
