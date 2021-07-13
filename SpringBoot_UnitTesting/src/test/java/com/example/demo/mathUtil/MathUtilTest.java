package com.example.demo.mathUtil;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DisplayName("Math Util test")
class MathUtilTest {
/*
    Note:-

     * By default in Junit , it crate instance for all methods and if you want to create instance of this test class
      only once then you should use @TestInstance.
     * BeforeAll() method should be STATIC or create Test-instance per_class

    @BeforeAll
    static void beforeAllInit(){
        System.out.println("This method have to run before all(before MathUtilTest class is initialize ");
    }


    //OR
    @BeforeAll
    void beforeAllInit(){
        System.out.println("This method have to run before all(before MathUtilTest class is initialize ");
    }
 */

    MathUtil mathUtil;
    @BeforeEach
    void init(){
        mathUtil=new MathUtil();
    }

//    @AfterEach
//    void afterInit(){
//        System.out.println("cleaning up code after each method");
//    }




   // @DisplayName, is uses to display proper message about each test case
    @Tag("Math")
    @Test
    @DisplayName("Test addition of 2 Numbers")
    void testAdditionOfTwoNumbers() {
        //given
        int firstNum=2;
        int secondNum=5;

        // when
        int actual=mathUtil.add(firstNum,secondNum);

        // then
        int expected=7;
        assertEquals(expected,actual,()->"Must be equal to 7");
        // OR
        //assertThat(actual).isEqualTo(actual);
    }



    /*
    Suppose, in particular case you don't want to run any specific Test (or you just want to skip any particular test)
    example:- In Test Driven Development (TDD) you want to skip that Test , because its obvious Test  gonna fail(Because Method is not implemented)
     */
    @Tag("Math")
    @Test
    @DisplayName("TDD method should not run")
    @Disabled
    void testAreaOfCircle(){
        fail("This Test should be disabled");
        //given
        double radius=10;

        // when
        double actual=mathUtil.areaOfCircle(radius);

        // then
        double expected=314.1592653589793;
        assertEquals(expected,actual,()->"area of circle of 10 should be 314.1592653589793");
    }



    // @assertAll :- asset multiple test cases at once and check if all are working or not(Note: it uses lambda)
    // In order to pass this Test all assert method should be passed..
    @Tag("Math")
    @Test
    @DisplayName("Testing multiplication ")
    void testProductOfNumbers(){
        assertAll(
                ()-> assertEquals(8,mathUtil.multi(4,2)),
                ()-> assertEquals(0,mathUtil.multi(5,0)),
                ()->assertEquals(-4,mathUtil.multi(2,-2))
        );
    }



    // Working with @Nested
    @Tag("Math")
    @Nested
    @DisplayName("Add method")
    class addTest{

        @Test
        @DisplayName("When adding 2 positive numbers")
        void addTwoPositiveNumber(){
            int expected=4;
            int actual=mathUtil.add(2,2);
            assertEquals(expected,actual,()-> "Should return sum of 2 positive numbers");
            /*
                Note:-
                assertEquals(expected,actual,"Should return sum of 2 positive numbers");  // Old Code
                 * message only display when test will fail , But this message will created every time and display only when fail
                 * It take memory also, So to avoid that you can pass message using Lambda
                 * Lambda will only execute the message when Test is fail
             */
        }

        @Tag("Math")
        @Test
        @DisplayName("When adding 2 negative numbers")
        void addTwoNegativeNumber(){
            int expected=-4;
            assertEquals(expected,mathUtil.add(-2,-2),()->"Should return sum of 2 negative numbers");
        }
    }



    // Testing Exception with @Repeated(No need of @Test) ---> @Repeated is used when you want want to repeat Test more than 1 times
    // This is the not perfect example of using @RepeatedTest but in future you can use this according to your need
    @Tag("Exception")
    @RepeatedTest(3)
    @DisplayName("Testing Arithmetic Exception")
    void testArithmeticException(RepetitionInfo repetitionInfo){
 //       Note:- According to our logic you can use  repetitionInfo to performing something in your code
//        repetitionInfo.getCurrentRepetition();
//        repetitionInfo.getTotalRepetitions();
        assertThrows(ArithmeticException.class,() ->mathUtil.divide(5,0),()-> "should return Arithmetic exception");
    }
}




/*
    **** Important Notes****


    * @Tag is used to tag Test according to your need, Suppose you Only want to run "Math" tag Test cases or "Exception" Test cases.
    * You can enable @Tag by Intelli_J settings or by Maven pom.xml file.

    ----------------------------------------------------------
    # Other Assert methods:-

    * assertTrue(condition) // check whether condition is true
    * assertFalse(condition) // check whether condition is false
    * assertNull(condition) // check whether condition is Null
    * assertNotNull(condition) // check whether condition is not Null
    * assertArrayEquals(expected,actual) // check 2 arrays
    *
    ----------------------------------------------------------
    # Conditional Execution Annotations:-

    @EnabledOnOS(OS.LINUX) // this Test will only run in Linux
    @EnabledOnJre(JRE.JAVA_11 // This test will only if Java V11
    @EnabledIf
    @EnabledIfSystemProperty
    @EnabledIfEnvironmentVariable

    assumeTrue(boolean_value); // if your assumption will True than only run this Test
    example:- If Server is UP than only run this test.

 */