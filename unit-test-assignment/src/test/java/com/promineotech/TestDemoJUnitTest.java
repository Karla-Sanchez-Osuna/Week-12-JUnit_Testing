package com.promineotech;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;;


class TestDemoJUnitTest {
	
	private TestDemo testDemo;

	@BeforeEach
	void setUp() throws Exception {
		testDemo = new TestDemo();
	}

	@ParameterizedTest
	@MethodSource("com.promineotech.TestDemoJUnitTest#argumentsForAddPositive")
	
	void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected, boolean expectException) {
		// Given: two numbers
		if(!expectException) {
			assertThat(testDemo.addPositive(a, b)).isEqualTo(expected);
		} else {
			// When (is test): the numbers are added
			// Then(is result): the returned value was expected
			  assertThatThrownBy(() -> testDemo.addPositive(a, b)).isInstanceOf(IllegalArgumentException.class);

			  	
		}		
	}

	static Stream<Arguments> argumentsForAddPositive() {
		
		return Stream.of(
				arguments(2, 4, 6, false),
				arguments(3, 0, 3, true),
				arguments(0, 0, 0, true),
				arguments(-1, 4, 3, true),
				arguments(2, -3, -11, true),
				arguments(7, 5, 12, false)

				);
		
	}
	@Test
	void assertThatPairsOfPositiveNumbersAreAddedCorrectly() {
		assertThat(testDemo.addPositive(4,5)).isEqualTo(9);
		assertThat(testDemo.addPositive(10,4)).isEqualTo(14);
		assertThat(testDemo.addPositive(40,50)).isEqualTo(90);
	}
	
	@ParameterizedTest
	@MethodSource("com.promineotech.TestDemoJUnitTest#argumentsForIsResultAnEvenNumber")
	
	void assertThatNumbersEqualAnEvenNumber( int a , int b, boolean expected, boolean expectException ) {
		if(!expectException) {
			
			// Given: two numbers
			//When the sum is even
			// Then it was expected
			assertThat(testDemo.isResultAnEvenNumber(a, b)).isEqualTo(expected);
			
		} else {
			assertThatThrownBy( () -> testDemo.isResultAnEvenNumber(a, b)).isInstanceOf(IllegalArgumentException.class);
		}
		
		
		}
	

	static Stream<Arguments> argumentsForIsResultAnEvenNumber() {
	
	return Stream.of(
			arguments(2, 4, true, false),
			arguments(0, 0,  true, false),
			arguments(2, -3,  false, true),
			arguments(7, 5, true, false),
			arguments(5, 5,true, false),
			arguments(-5, -8,false, true),
			arguments(7, 6,false, true),
			arguments(-8, -6,true, false)



			);
	}
	
	@Test
	void assertThatNumberSquaredIsCorrect() {
		TestDemo mockDemo = spy(testDemo);
		
		doReturn(5).when(mockDemo).getRandomInt();
		
		
		int fiveSquared = mockDemo.randomNumberSquared();
		
		assertThat(fiveSquared).isEqualTo(25);
		
	}
	
	
	
}// end of class
