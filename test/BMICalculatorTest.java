import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class BMICalculatorTest {
    private BMICalculator bmiCalculator;

    @BeforeEach
    void beforeEach(){
        bmiCalculator = new BMICalculator();

    }
    @DisplayName("TC02: Weight (kg) – 50 \n" +
            "\n" +
            "Height (meters) – 2 ")
    @Test
    void testCalculateBMI_WhenFiftyKgAndTwoMeter_ShouldReturnTwentyFive() {
        double result = bmiCalculator.calculateBMI(50, 2);
        assertEquals(12.50,result);
    }

    @DisplayName("TC03: Weight is zero, expect IllegalArgumentException")
    @Test
    void testCalculateBMI_WhenZeroKgAndTwoMeter_ShouldThrowNewIllegalArgumentException() {
        double weightInKg = 0;
        double heightInMeters = 2;
        String expectedExceptionMessage = "Weight and height must be greater than zero";
        IllegalArgumentException actualException = assertThrows(IllegalArgumentException.class, () -> {
            bmiCalculator.calculateBMI(weightInKg,heightInMeters);
        });

        assertEquals(expectedExceptionMessage,actualException.getMessage(),
        "Unexpected exception message");

    }

    @DisplayName("TC04: Height is zero , expect IllegalArgumentException")
    @Test
    void testCalculateBMI_WhenTwoKgAndZeroMeter_ShouldThrowNewIllegalArgumentException() {
        double weightInKg = 2;
        double heightInMeters = 0;
        String expectedExceptionMessage = "Weight and height must be greater than zero";
        IllegalArgumentException actualException = assertThrows(IllegalArgumentException.class, () -> {
            bmiCalculator.calculateBMI(weightInKg,heightInMeters);
        });

        assertEquals(expectedExceptionMessage,actualException.getMessage(),
                "Unexpected exception message");

    }

    @DisplayName("TC05: Negative Weight  , expect IllegalArgumentException")
    @Test
    void testCalculateBMI_WhenNegativeWeight_ShouldThrowNewIllegalArgumentException() {
        double weightInKg = -20;
        double heightInMeters = 2;
        String expectedExceptionMessage = "Weight and height must be greater than zero";
        IllegalArgumentException actualException = assertThrows(IllegalArgumentException.class, () -> {
            bmiCalculator.calculateBMI(weightInKg,heightInMeters);
        });

        assertEquals(expectedExceptionMessage,actualException.getMessage(),
                "Unexpected exception message");

    }

    @DisplayName("TC06: Negative height  , expect IllegalArgumentException")
    @Test
    void testCalculateBMI_WhenNegativeHeight_ShouldThrowNewIllegalArgumentException() {
        double weightInKg = 2;
        double heightInMeters = -20;
        String expectedExceptionMessage = "Weight and height must be greater than zero";
        IllegalArgumentException actualException = assertThrows(IllegalArgumentException.class, () -> {
            bmiCalculator.calculateBMI(weightInKg,heightInMeters);
        });

        assertEquals(expectedExceptionMessage,actualException.getMessage(),
                "Unexpected exception message");

    }

    @DisplayName("TC07: BMI < 18.5  , expect  “Underweight”  ")
    @Test
    void testClassifyBMI_WhenBMILessThanEighteenDotFive_ShouldReturnUnderweight() {
       String  bmi = bmiCalculator.classifyBMI(16);
        String expectedMessage = "Underweight";
        assertEquals(expectedMessage, bmi);
    }

    @DisplayName("TC08: 18.5 <= BMI < 24.9   , expect  “Normal weight”   ")
    @Test
    void testClassifyBMI_WhenBMIBetweenEighteenDotFiveAndTwentyFourDotNine_ShouldReturnNormalWeight() {
        String  bmi = bmiCalculator.classifyBMI(18.5);
        String expectedMessage = "Normal weight";
        assertEquals(expectedMessage, bmi);
    }

    @DisplayName("TC09: 24.9 <= BMI < 30   , expect  “Overweight”    ")
    @Test
    void testClassifyBMI_WhenBMIBetweenTwentyFourDotNineAndThirty_ShouldReturnOverweight() {
        String  bmi = bmiCalculator.classifyBMI(24.9);
        String expectedMessage = "Overweight";
        assertEquals(expectedMessage, bmi);
    }

    @DisplayName("TC10: BMI >= 30   , expect  “Obese”   ")
    @Test
    void testClassifyBMI_WhenBMIGreaterThanThirty_ShouldReturnObese() {
        String  bmi = bmiCalculator.classifyBMI(60);
        String expectedMessage = "Obese";
        assertEquals(expectedMessage, bmi);
    }

    @DisplayName("TC11: 18.5 <= BMI < 24.9   , expect  “Normal weight”  ")
    @ParameterizedTest(name = "BMI = {0} , Expected = {1}")
    @CsvSource({
            "17.9, Underweight",
            "18.5, Normal weight",
            "24, Normal weight",
            "24.8, Normal weight"
    })
    void testTC11ClassifyBMI_WithBoundaryValues_ShouldReturnExpectedClassification(double bmi, String expectedClassification) {
        // The 'bmi' and 'expectedClassification' values are passed automatically from the @CsvSource data
        assertEquals(expectedClassification, bmiCalculator.classifyBMI(bmi));
    }

    @DisplayName("TC12 24.9 <= BMI < 30   , expect  “Overweight”   ")
    @ParameterizedTest(name = "BMI = {0} , Expected = {1}")
    @CsvSource({
            "24.9, Overweight",
            "24.89, Normal weight",
            "29.9, Overweight",

    })
    void testTC12ClassifyBMI_WithBoundaryValues_ShouldReturnExpectedClassification(double bmi, String expectedClassification) {
        // The 'bmi' and 'expectedClassification' values are passed automatically from the @CsvSource data
        assertEquals(expectedClassification, bmiCalculator.classifyBMI(bmi));
    }

    @DisplayName("TC13 BMI >= 30    , expect  “Obese”    ")
    @ParameterizedTest(name = "BMI = {0} , Expected = {1}")
    @CsvSource({
            "30, Obese",
            "40, Obese",
            "100, Obese",

    })
    void testTC13ClassifyBMI_WithBoundaryValues_ShouldReturnExpectedClassification(double bmi, String expectedClassification) {
        // The 'bmi' and 'expectedClassification' values are passed automatically from the @CsvSource data
        assertEquals(expectedClassification, bmiCalculator.classifyBMI(bmi));
    }




}