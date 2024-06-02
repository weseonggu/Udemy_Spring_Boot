package com.in28minutes.rest.webservices.restfulwebservices.basic;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

//@Configuration
public class BasicAuthentiationSecurityConfiguration {
	// 스프링 시큐리티 필터체인 설정
	@Bean
	public SecurityFilterChain filterchain(HttpSecurity http) throws Exception {
		return
			
			http
				// 모든요청에대해서 인증을 활성화
				.authorizeHttpRequests(
						auth -> auth.antMatchers(HttpMethod.OPTIONS,"/**").permitAll()//만일 OPTIONS 요청이 어떤 URL 즉 "/**"에 유입을 허룔함
						.anyRequest().authenticated()
						)
				// 기본인증 활성화 팝업창
				.httpBasic(Customizer.withDefaults())
				// 상태가 없는 세션을 설정(CSRF를 비활성한다면 세션에 상태가 없어야한다.)
				.sessionManagement(
						session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
						)
				// CSRF비활성화
				.csrf().disable().build();

	}
}
