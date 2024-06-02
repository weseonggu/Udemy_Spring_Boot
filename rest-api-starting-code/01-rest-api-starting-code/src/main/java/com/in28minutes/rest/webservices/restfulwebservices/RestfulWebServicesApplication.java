package com.in28minutes.rest.webservices.restfulwebservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class RestfulWebServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestfulWebServicesApplication.class, args);
	}
	
	
	
//	@Bean
//	// WebMvcConfigurer 인터페이스를 구현채를 생성하고 반환함
//	public WebMvcConfigurer corsConfigurer() {
//		return new WebMvcConfigurer() {
//			public void addCorsMappings(CorsRegistry registry) {
//				registry.addMapping("/**")//특정한 패턴에 대해 크로스 오리진 리퀘스트 처리를 가능하게 해줌(/**는 모든것에 활성화함)
//				.allowedMethods("*")//어떤 종류의 메서드가 허용되는지 알려주는 거 GET, POST등등
//				.allowedOrigins("http://localhost:3000");// 요청이 오는곳
//			}
//		};
//	}
}
