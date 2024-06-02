package com.in28minutes.rest.webservices.restfulwebservices;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer{
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")//특정한 패턴에 대해 크로스 오리진 리퀘스트 처리를 가능하게 해줌(/**는 모든것에 활성화함)
		.allowedMethods("*")//어떤 종류의 메서드가 허용되는지 알려주는 거 GET, POST등등
		.allowCredentials(true)//쿠키 인증 요청 허용
		.allowedOrigins("http://localhost:3000");// 요청이 오는곳
	}
}
