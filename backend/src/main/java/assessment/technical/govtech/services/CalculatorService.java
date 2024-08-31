package assessment.technical.govtech.services;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
	
    public long addTwoNumbers(long firstNumber, long secondNumber) {
        return firstNumber + secondNumber;
    }
	
    public long subtractTwoNumbers(long firstNumber, long secondNumber) {
        return firstNumber - secondNumber;
    }
}
