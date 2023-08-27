package com.example.crops.security;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.python.antlr.ast.Pass;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class CustomUserDetailsService implements UserDetailsService {

    private PasswordEncoder passwordEncoder;

    public CustomUserDetailsService() {
        this.passwordEncoder = new BCryptPasswordEncoder();
    }


    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException{
        //ㄴ>loadUserByUsername의 반환타입은
        //  org.springframework.security.core.userdetails.UserDetails 패키지에
        //  UserDetails라는 인터페이스 타입으로 지정되어있음
        //  UserDetails 타입의 객체를 이용하여, 퍄스워트,사용자권한을 확인하는 방식으로 동작

        log.info("loadUserByUsername: "+ userId);

        UserDetails userDetails = User.builder().username("")
                .password(passwordEncoder.encode("1111"))
                .authorities("ROLE_USER")
                .build();

        return userDetails;
    }
}
