package com.cos.blog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.cos.blog.config.auth.PrincipalDetailService;

import jakarta.servlet.DispatcherType;
import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig {
	
	private final PrincipalDetailService princDetailService;
	
	@Bean
	public BCryptPasswordEncoder encodePWD() {
		return new BCryptPasswordEncoder();
	}
	
	public AuthenticationManager authenticationManager(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(princDetailService).passwordEncoder(encodePWD());
		return auth.build();
	}
	
	// Spring Security 6.1 이상 버전에서는 authorizeHttpRequests(), and(), formLogin() 등이 더 이상 권장되지 않고, 대신 Lambda DSL을 사용하는 방식으로 변경되었다.
	@Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())   // csrf 토큰 비활성화 (테스트시 걸어두는 게 좋음)
            .authorizeHttpRequests(authorize -> authorize
                .dispatcherTypeMatchers(DispatcherType.FORWARD).permitAll()
                .requestMatchers("/", "/auth/**", "/js/**", "/css/**", "/image/**").permitAll() // /auth/** 경로는 누구나 접근 가능
                .anyRequest()
                .authenticated() // 그 외 모든 요청은 인증 필요
            )
            .formLogin(form -> form
                .loginPage("/auth/loginForm") // 커스텀 로그인 페이지 설정
                .permitAll() // 로그인 페이지는 누구나 접근 가능
                .loginProcessingUrl("/auth/loginProc")  // 스프링 시큐리티가 해당 주소로 요청오는 로그인을 가로채서 대신 로그인 해준다.
                .defaultSuccessUrl("/")  // 요청이 정상적으로 처리되면 메인 페이지로 간다.
            );

        return http.build(); // SecurityFilterChain 반환
    }

}
