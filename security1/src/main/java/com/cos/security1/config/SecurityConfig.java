package com.cos.security1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    public BCryptPasswordEncoder encodePwd() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeHttpRequests()
                .requestMatchers("/user/**").authenticated()
                .requestMatchers("/manager/**").hasAnyRole("ADMIN", "MANAGER")
                .requestMatchers("/amdin/**").hasRole("ADMIN")
                .anyRequest().permitAll()
                .and()
            .formLogin()
                .loginPage("/loginFrom")
                .loginProcessingUrl("/login") // login주소가 호출되면 시큐리티가 낚아챔. -> controller에 매핑안해도됨.
                .defaultSuccessUrl("/"); //로그인 완료 후, 리다이렉트
        return http.build();
    }
}

