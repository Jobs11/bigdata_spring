# bigdata_spring
⭐️@RequiredArgsConstructor
- @RequiredArgsConstructor를 사용하면 해당 클래스의 필드 중 final이나 @NonNull 어노테이션이 붙은 필드들에 대한 생성자를 자동으로 생성(초기화)
- 따라서 @Autowired등을 통한 의존성주입이 따로 필요없음

⭐️시큐리티(Security)
- dependency에 시큐리티를 사용하고 SecurityConfig를 만들면(@Configuration 선언하자) 자동으로 모든 경로로 로그인해라는 설정이 나옴
  ㄴ 따로 설정을 하고 싶은 경우 -> SecurityConfig안에 SecurityFilterChain이라는 객체 반환 메소드를 작성해야함
- css나 js같은 정적자원들에도 필터가 적용되기 때문에 webSecurityCustomizer()메소드를 추가해서 동작하지 않도록 해야함
  
- 인증(Authentication) = 로그인, 비밀번호등으로 자신을 증명하는 것
  ㄴ>인증 처리를 위해서는 UserDetailsService 인터페이스 사용해야함
      ㄴ> CustomUserDetailsService.class를 추가해서 관리하자(UserDetailsService인터페이스를 상속받아서)
      ㄴ>UserDetailsService 인터페이스는 loadUser ByUsername()라는 메서드 단하나의 메소드를 가지는데, 이 부분이 실제 인증을 처리할 때 호출되는 부분
  ㄴ> 시프링 시큐리티는 기본적으로 PasswordEncoder가 필요함 => SecurityConfig에 @Bean으로 추가하자
  ㄴ> 어노테이션으로 권한 체크를 하려는 경우 들어가려고 하는 경로에(컨트롤러) + @PreAuthorize("hasRole('USER' || 'ADMIN')")등으로 체크할 수도 있다.
  (참조) @EnableWebSecurity는 전반적인 웹 보안 설정을 다루고, @EnableGlobalMethodSecurity는 메소드 수준의 보안 설정
  (참조) CSRF토큰 = 사용자가 사이트를 이용할때 매번 변경되는 문자열을 생성하고, 무언가 요청시 검증하는 방식 <- 시큐리티는 기본적으로 GET방식을 제외한 모든 요청에 CSRF토큰을 요구함
  
  
  
- 인가(Authoriztion) = 인증된 사용자라도 , 접근할 수 있는 권한이 있는지 확인하는 것
- 
