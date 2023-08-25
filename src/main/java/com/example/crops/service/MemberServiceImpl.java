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
    public MemberVO getMemberById(String userId) {
        return memberMapper.getMemberById(userId);
    }

    @Override
    public void insertMember(MemberVO member) {
        memberMapper.insertMember(member);
    }


    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        MemberVO member = memberService.getMemberById(userId); // 실제로 사용자 정보를 가져와야 함

        if (member == null) {
            throw new UsernameNotFoundException(userId);
        }

        //UserDetail을 구현하고 있는 User객체를 반환해줌
        //User객체를 생성하기 위해 생성자로 회원의 이메일, 비밀번호, role를 파라미터로 넘겨줌
        return User.builder()
                .username(member.getUserId())
                .password(member.getPassword())
                .authorities("ROLE_USER")
                .build();
    }
}
