import calculator.Calculator;
import static org.junit.Assert.*;
import org.junit.Test;

public class CalculatorTest {
    private static final double DELTA = 1e-15;
    Calculator calculator = new Calculator();

    @Test
    public void factorialTruePositive(){
        assertEquals("Finding factorial of a number for True Positive", 720, calculator.factorial(6), DELTA);
        assertEquals("Finding factorial of a number for True Positive", 1, calculator.factorial(1), DELTA);
        assertEquals("Finding factorial of a number for True Positive", 6, calculator.factorial(3), DELTA);
        assertEquals("Finding factorial of a number for True Positive", 24, calculator.factorial(4), DELTA);
        assertEquals("Finding factorial of a number for True Positive", 1, calculator.factorial(0), DELTA);
    }

    @Test
    public void factorialFalsePositive(){
        assertNotEquals("Finding factorial of a number for False Positive", 113, calculator.factorial(5), DELTA);
        assertNotEquals("Finding factorial of a number for False Positive", 10, calculator.factorial(6), DELTA);
        assertNotEquals("Finding factorial of a number for False Positive", 42, calculator.factorial(4), DELTA);
        assertNotEquals("Finding factorial of a number for False Positive", 9, calculator.factorial(2), DELTA);
        assertNotEquals("Finding factorial of a number for False Positive", 0, calculator.factorial(0), DELTA);
    }

    @Test
    public void powerTruePositive(){
        assertEquals("Finding power for True Positive", 8, calculator.power(2, 3), DELTA);
        assertEquals("Finding power for True Positive", 1, calculator.power(1, 3), DELTA);
        assertEquals("Finding power for True Positive", 81, calculator.power(3, 4), DELTA);
        assertEquals("Finding power for True Positive", 64, calculator.power(4, 3), DELTA);
        assertEquals("Finding power for True Positive", 25, calculator.power(5, 2), DELTA);
    }

    @Test
    public void powerFalsePositive(){
        assertNotEquals("Finding power for False Positive", 6, calculator.power(2, 3), DELTA);
        assertNotEquals("Finding power for False Positive", -7, calculator.power(3, 3), DELTA);
        assertNotEquals("Finding power for False Positive", 99, calculator.power(4, 3), DELTA);
        assertNotEquals("Finding power for False Positive", -12, calculator.power(5, 3), DELTA);
    }

    @Test
    public void logTruePositive(){
        assertEquals("Finding natural log for True Positive", 0, calculator.log(1), DELTA);

    }

    @Test
    public void logFalsePositive(){
        assertNotEquals("Finding natural log for False Positive", 60, calculator.log(2.4), DELTA);
        assertNotEquals("Finding natural log for False Positive", 4.7, calculator.log(2.1), DELTA);
    }

    @Test
    public void squareRootTruePositive(){
        assertEquals("Finding square root for True Positive", 4, calculator.square_root(16), DELTA);
        assertEquals("Finding square root for True Positive", 1, calculator.square_root(1), DELTA);
        assertEquals("Finding square root for True Positive", 9, calculator.square_root(81), DELTA);
        assertEquals("Finding square root for True Positive", 6, calculator.square_root(36), DELTA);
    }

    @Test
    public void squareRootFalsePositive(){
        assertNotEquals("Finding square root for False Positive", 1, calculator.square_root(3), DELTA);
        assertNotEquals("Finding square root for False Positive", 3, calculator.square_root(4), DELTA);
        assertNotEquals("Finding square root for False Positive", 4, calculator.square_root(81), DELTA);
        assertNotEquals("Finding square root for False Positive", 2, calculator.square_root(36), DELTA);

    }


}
