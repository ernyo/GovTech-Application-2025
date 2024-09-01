package assessment.technical.govtech;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigInteger;

import org.junit.jupiter.api.Test;

import assessment.technical.govtech.services.CalculatorService;

class CalculatorTests {

	private final CalculatorService calculatorService = new CalculatorService();

    @Test
    void testAdditionWithBigInteger() {
        BigInteger num1 = new BigInteger("9223372036854775807"); // Long.MAX_VALUE
        BigInteger num2 = new BigInteger("1");
        BigInteger result = calculatorService.addTwoNumbers(num1, num2);

        assertEquals(new BigInteger("9223372036854775808"), result); // Check for correct overflow handling
    }

    @Test
    void testSubtractionWithBigInteger() {
        BigInteger num1 = new BigInteger("-9223372036854775808"); // Long.MIN_VALUE
        BigInteger num2 = new BigInteger("1");
        BigInteger result = calculatorService.subtractTwoNumbers(num1, num2);

        assertEquals(new BigInteger("-9223372036854775809"), result); // Check for correct underflow handling
    }
    
}
