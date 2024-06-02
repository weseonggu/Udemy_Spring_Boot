package com.in28minutes.mockito.mockitodemo.business;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
@ExtendWith(MockitoExtension.class)
class SomeBusinessImplMockTest {
	
	@Mock
	private DataService dataServiceMock;
	
	@InjectMocks
	private SomeBusinessImpl businessImpl;
	
	@Test
	void findTheGreatestFromAllData_basic() {
		
//		DataService dataServiceMock = mock(DataService.class);// @Mock 어노테이션으로 대체
		
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {25,15,5});
		
//		SomeBusinessImpl businessImpl = new SomeBusinessImpl(dataServiceMock); //@InjectMocks 어노테이션으로 대체
		int result = businessImpl.findTheGreatestFromAllData();
		assertEquals(25, result);
	}

}


