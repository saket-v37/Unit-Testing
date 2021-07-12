package com.example.demo;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class DemoApplicationTests {


	Calculator underTest =new Calculator();

	@Test
	public void itShouldAddTwoNumbers(){
		//given
		 int firstNumber=20;
		 int secondNumber=30;

		 // when
		int result= underTest.add(firstNumber,secondNumber);

		// then
		int expectedValue=50;
		assertThat(result).isEqualTo(expectedValue);

	}



	class Calculator{
		public int add(int a,int b){
			return a+b;
		}
	}

}
