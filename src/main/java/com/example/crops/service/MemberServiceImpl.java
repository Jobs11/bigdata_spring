package com.example.crops.service;

import com.example.crops.domain.MemberVO;
import com.example.crops.mapper.MemberMapper;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {


    private final MemberMapper memberMapper; // 이곳에 final 키워드를 추가합니다
    private MemberService memberService;
    private MemberVO memberVO;

    // 생성자 주입
    public MemberServiceImpl(MemberMapper memberMapper) {
        this.memberMapper = memberMapper;

    }

    @Override
    public MemberVO getMemberById(String username) {
        return memberMapper.getMemberById(username);
    }

    @Override
    public void insertMember(MemberVO member) {
        memberMapper.insertMember(member);
    }



}
