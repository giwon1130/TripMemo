package com.ig.tripmemo.config.security;

import com.ig.tripmemo.config.security.jwt.JwtAccessDeniedHandler;
import com.ig.tripmemo.config.security.jwt.JwtAuthenticationEntryPoint;
import com.ig.tripmemo.config.security.jwt.JwtSecurityConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final TokenProvider tokenProvider;
    private final JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
    private final JwtAccessDeniedHandler jwtAccessDeniedHandler;


    // PasswordEncoder는 BCryptPasswordEncoder를 사용
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                // CSRF(Cross-Site Request Forgery) 공격 방지를 비활성화
                .csrf().disable()

                .exceptionHandling()
                .authenticationEntryPoint(jwtAuthenticationEntryPoint)
                .accessDeniedHandler(jwtAccessDeniedHandler)

                // 세션을 사용하지 않기 때문에 STATELESS로 설정
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)

                .and()
                .authorizeHttpRequests() // HttpServletRequest를 사용하는 요청들에 대한 접근제한을 설정하겠다.
                .requestMatchers("/api/authenticate").permitAll() // 로그인 api
                .requestMatchers("/api/signup").permitAll() // 회원가입 api
                .requestMatchers("/favicon.ico").permitAll()
                .anyRequest().authenticated() // 그 외 인증 없이 접근X

                .and()
                .apply(new JwtSecurityConfig(tokenProvider)); // JWT 기반 인증 설정

        return httpSecurity.build();
    }
}