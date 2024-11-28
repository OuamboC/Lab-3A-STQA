import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    //Declare an instance variable for the Calculator object
    private Calculator calculator;

    @BeforeEach
    void beforeEach(){
            //Add a single statement that create  a Calculator object
        calculator = new Calculator();


    }

    @DisplayName("Test 10/2 = 5")
    @org.junit.jupiter.api.Test
    void testdivision() {
       int result =  calculator.division(10 ,2);
        assertEquals(5, result );
    }
    @DisplayName("Test /zero")
    @org.junit.jupiter.api.Test
    void testDivision_WhenTensDividedByZero_ShouldThrowArithmeticException(){
        int dividend = 10 ;
        int divisor = 0;
        String expectedExceptionMessage = "/ by zero";
        ArithmeticException actualException = assertThrows(ArithmeticException.class, () -> {
            calculator.division(dividend, divisor);
        }, "Division by zero should have thrown an Arithmetic Exception.");

        assertEquals(expectedExceptionMessage, actualException.getMessage(),
        "Unexpected exception message");
    }
    @DisplayName("Test 30/3= 10")
    @Test
    void testIntegerDivision_WhenThirtyIsDividedByThree_ShouldReturnTen() {
        int result = calculator.division(30,3);
        assertEquals(10,result);

    }
}