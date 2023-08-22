package com.example.crops.service;

import com.example.crops.domain.MemberVO;

public interface MemberService {
    public void insert(MemberVO member);
    public MemberVO getMem(String id, String password);
}
