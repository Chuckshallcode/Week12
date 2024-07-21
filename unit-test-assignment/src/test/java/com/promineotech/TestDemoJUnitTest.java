package com.promineotech;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.doReturn;

import static org.junit.jupiter.params.provider.Arguments.arguments;

class TestDemoJUnitTest {

	private TestDemo testDemo;
	
	@BeforeEach
	void setUp() throws Exception {
		testDemo = new TestDemo();
	}
	
	@ParameterizedTest
	@MethodSource("com.promineotech.TestDemoJUnitTest#argumentsForAddPositive")
	  public void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected, boolean expectException) {
		
		if(!expectException) {
			assertThat(testDemo.addPositive(a,b)).isEqualTo(expected);  //Checks that the input is the same as =
		} else {														// What it should be
			assertThatThrownBy(() -> testDemo.addPositive(a,b)).isInstanceOf(IllegalArgumentException.class); // Or else throw an exception
		}												
	}
	
	static Stream<Arguments> argumentsForAddPositive() { //1-4, j
		return Stream.of(
				arguments(2, 4, 6, false), // false is actually good here
				arguments(4, 5, 9, false),
				arguments(40, 50, 90, false),
				arguments(1, -2, 4, true) // this show the program can catch when inputs are bad
				);
	}
	
	static Stream<Arguments> argumentsForNegativeNumbers() { //1-4, j
		return Stream.of(
				arguments(-2, 4, false, true), //false and true are basically flipped
				arguments(-4, -5, true, false),
				arguments(40, 50, false, true)
				);
	}
		
	@Test
	void assertThatPairsOfPositiveNumbersAreAddedCorrectly() { // alternative version
		
		assertThat(testDemo.addPositive(2,4)).isEqualTo(6);	
		assertThat(testDemo.addPositive(4,5)).isEqualTo(9);	
		assertThat(testDemo.addPositive(40, 50)).isEqualTo(90);

	}
	
	@ParameterizedTest
	@MethodSource("com.promineotech.TestDemoJUnitTest#argumentsForNegativeNumbers")
	public void assertThatTwoNumbersAreBothNegative(int a, int b, boolean expected, boolean expectException) {
		if (!expectException) {
			assertThat(testDemo.negativeNumbers(a, b)).isEqualTo(expected);
		} else {
			assertThatThrownBy(() -> testDemo.negativeNumbers(a, b)).isInstanceOf(IllegalArgumentException.class);
		}
	}
		
	@Test
	void assertThatNumberSquaredIsCorrect() {
		TestDemo mockDemo = spy(testDemo);
		
		doReturn(5).when(mockDemo).getRandomInt(); //we basically sub 5 in
												//instead of it being random
		int fiveSquared = mockDemo.randomNumberSquared();
		
		assertThat(fiveSquared).isEqualTo(25);
		
	}
	
	
}
