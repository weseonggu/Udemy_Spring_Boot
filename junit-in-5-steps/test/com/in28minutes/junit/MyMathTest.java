package com.in28minutes.junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MyMathTest {

	private MyMath math = new MyMath();
	
	@Test
	void calculateSum_ThreeMemberArray() {		
		assertEquals(6, math.calculateSum(new int[] {1,2,3}));// assertEquals(예상값, 실행할 메서드);
	}

	@Test
	void calculateSum_ZeroLengthArray() {		
		assertEquals(1, math.calculateSum(new int[] {}));
	}

}