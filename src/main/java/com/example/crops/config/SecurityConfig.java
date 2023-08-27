package com.example.crops.config;

import com.example.crops.security.CustomUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true) //특정경로에 시큐리티를 적용하려는경우
public class SecurityConfig {

    private final CustomUserDetailsService userDetailsService; //remember-me를 위해 필요
    private final DataSource dataSource; //remember-me를 위해 필요

    public SecurityConfig(CustomUserDetailsService userDetailsService, DataSource dataSource) {
        this.userDetailsService = userDetailsService;
        this.dataSource = dataSource;
    }


    //WebSecurityConfigurationAdapter는 이제 사장되어서 override하여 SecurityFilterChain을 사용할 수 없다
    //따라서 직접 SecurityFilterChain을 Bean으로 설정하여 밑에 필요한 부분을 커스터마이징 하면 된다.
    ///
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {


        http
                .csrf().disable()
                .formLogin()
                .loginPage("/member/login")
                .defaultSuccessUrl("/")
                .usernameParameter("userId")
                .failureUrl("/member/login/error")
                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/member/logout"))
                .logoutSuccessUrl("/")
        ;

        http.rememberMe()
                .key("354512")
                .tokenRepository(persistentTokenRepository())
                .userDetailsService(userDetailsService)
                .tokenValiditySeconds(60*60);


        http.authorizeRequests()
                //permitAll()을 사용하여 모든 사용자가 인증없이 해당결로에 접근할 수 있도록 해줌
                .anyRequest().permitAll()
                //여기에는 hasRole("ADMIN")을 적어줌으로써 /admin/의 경로로오는 모든 사이트를 ADMIN역할인경우에만 허용하겠다고 해줌
//                .mvcMatchers("/admin/**").hasRole("ADMIN")
                //위에서 설정해준 경로를 제외한 모든 접근은 인증을 요구하도록 해줌
        ;

        http.exceptionHandling()
                .authenticationEntryPoint(new CustomAuthenticationEntryPoint())
        ;

        return http.build();
    }

    /*스프링 시큐리티의 인증을 담당하는 AuthenticationManager는 이전 설정 방법으로
     authenticationManagerBuilder를 이용해서 userDetailsService와 passwordEncoder를 설정해주어야 했습니다.
     그러나 변경된 설정에서는 AuthenticationManager 빈 생성 시 스프링의 내부 동작으로 인해
      위에서 작성한 UserSecurityService와 PasswordEncoder가 자동으로 설정됩니다.*/

//    @Bean
//    AuthenticationManager authenticationManager(
//            AuthenticationConfiguration authenticationConfiguration) throws Exception {
//        return authenticationConfiguration.getAuthenticationManager();
//    }

    @Bean
    //static디렉터리의 하위파일은 인증을 무시하도록 넣어주는것
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().antMatchers("/css/**", "/js/**", "/image/**");
    }


    //BCryptPasswordEncoder는 BCrypt 해시 알고리즘을 사용하여 비밀번호를 암호화하여 비밀번호를 보호
    //BCryptPasswordEncoder를 사용하여 암호화한 후,
    //해당 암호화된 비밀번호를 데이터베이스나 다른 저장소에 저장하여 사용자 인증에 활용
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public PersistentTokenRepository persistentTokenRepository(){
        JdbcTokenRepositoryImpl repo = new JdbcTokenRepositoryImpl();
        repo.setDataSource(dataSource);
        return repo;
    }
}
