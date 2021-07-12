package com.example.demo.mathUtil;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MathUtilTest {

    MathUtil mathUtil;
    @BeforeEach
    void init(){
        mathUtil=new MathUtil();
    }


    @Test
    void testAdditionOfTwoNumbers() {
        //given
        int firstNum=2;
        int secondNum=5;

        // when
        int actual=mathUtil.add(firstNum,secondNum);

        // then
        int expected=7;
        assertEquals(expected,actual,"Must be equal to 7");
        // OR
        //assertThat(actual).isEqualTo(actual);
    }

    @Test
    void testAreaOfCircle(){
        //given
        double radius=10;

        // when
        double actual=mathUtil.areaOfCircle(radius);

        // then
        double expected=314.1592653589793;
        assertEquals(expected,actual,"area of circle of 10 should be 314.1592653589793");

    }


    // testing exception
    @Test
    void testArithmeticException(){
        assertThrows(ArithmeticException.class,() ->mathUtil.divide(5,0),"should return Arithmetic exception");
    }
}