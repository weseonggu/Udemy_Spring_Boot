package com.in28minutes.mockito.mockitodemo.business;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SomeBusinessImplStubTest {

	@Test
	void findTheGreatestFromAllData_basic() {
		DataServiceStub dataServiceStub = new DataServiceStub();
		SomeBusinessImpl businessImpl = new SomeBusinessImpl(dataServiceStub);
		int result = businessImpl.findTheGreatestFromAllData();
		assertEquals(25, result);
	}

}


class DataServiceStub implements DataService{

	@Override
	public int[] retrieveAllData() {
		// TODO Auto-generated method stub
		return new int[]{25,15,5};
	}
}

//문제점
// 1. DataServicce에 새로운 매소드가 추가되면 DataServiceStub구현 클래스도 업데이트를 해줘야합니다.
// 2. 더 중요한 문제는 Stub을 이용하면 많은 시나리오를 테스트하기가 매우 어렵다 ex) 시나리오가 여러개이면 DataServiceStub 구현클래스도 여러개 생겨야함 