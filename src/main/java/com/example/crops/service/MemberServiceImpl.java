package com.example.crops.service;

import com.example.crops.domain.MemberVO;
import com.example.crops.mapper.MemberMapper;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService{

    private MemberMapper memberMapper;
    @Override
    public void insert(MemberVO member) {
        memberMapper.insert(member);
    }

    @Override
    public MemberVO getMem(String id, String password) {
        return memberMapper.getMem(id, password);
    }
}
