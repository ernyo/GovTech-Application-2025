package assessment.technical.govtech.services;

import java.math.BigInteger;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
	
    public BigInteger addTwoNumbers(BigInteger firstNumber, BigInteger secondNumber) {
        return firstNumber.add(secondNumber);
    }
	
    public BigInteger subtractTwoNumbers(BigInteger firstNumber, BigInteger secondNumber) {
        return firstNumber.subtract(secondNumber);
    }
}
