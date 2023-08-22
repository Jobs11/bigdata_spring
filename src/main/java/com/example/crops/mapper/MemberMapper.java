package com.example.crops.mapper;

import com.example.crops.domain.MemberVO;

public interface MemberMapper {
    public void insert(MemberVO member);
    public MemberVO getMem(String id, String password);
}
