package com.example.crops.mapper;

import com.example.crops.domain.MemberVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.context.annotation.Bean;

@Mapper
public interface MemberMapper {
    public void insertMember(MemberVO member);
    public MemberVO getMemberById(String userId);

    public MemberVO loginMember(String userId, String password);


}
