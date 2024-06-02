package com.in28minutes.junit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MyBeforeAfterTest {

	
	@BeforeAll//모든 테스트에서 공통적으로 수행하려는 설정이 필요한경우
	static void beforeAll() {//  클래스 레벨의 메서드이기때문에 static아어야 함
		System.out.println("beforeAll");
	}
	
	@BeforeEach// 테스트를 하기전에 한번씩 실행됨 EX: 테스트전 수행해야하는 설정이있을 경우
	void beforeEach() {
		System.out.println("BeforeEach");
	}

	@Test
	void test1() {
		System.out.println("test1");
	}

	@Test
	void test2() {
		System.out.println("test2");
	}

	@Test
	void test3() {
		System.out.println("test3");
	}

	@AfterEach// 테스트후 한번씩 실행됨 EX: 테스트후 정리가 필요한경우
	void afterEach() {
		System.out.println("AfterEach");
	}

	@AfterAll
	static void afterAll() {
		System.out.println("afterAll");
	}

}