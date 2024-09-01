package assessment.technical.govtech.controllers;

import java.math.BigInteger;
import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import assessment.technical.govtech.services.CalculatorService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class CalculatorController {
	
	private CalculatorService calculatorService;

	public CalculatorController(CalculatorService calculatorService) {
		this.calculatorService = calculatorService;
	}
	
	@PostMapping(
		value = "/add", 
		consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, 
		produces = MediaType.APPLICATION_JSON_VALUE
	)
    public ResponseEntity<Map<String, String>> addTwoNumbers(BigInteger firstNumber, BigInteger secondNumber) {
		try {
			BigInteger result = calculatorService.addTwoNumbers(firstNumber, secondNumber);
			return ResponseEntity.ok(Map.of("result", result.toString()));
		} catch (ArithmeticException e) {
            return ResponseEntity.badRequest().body(Map.of("error", "Overflow error occurred"));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(Map.of("error", "Server error"));
        }
    }
	
	@PostMapping(
		value = "/subtract", 
		consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, 
		produces = MediaType.APPLICATION_JSON_VALUE
	)
    public ResponseEntity<Map<String, String>> subtractTwoNumbers(BigInteger firstNumber, BigInteger secondNumber) {
		try {
			BigInteger result = calculatorService.subtractTwoNumbers(firstNumber, secondNumber);
			return ResponseEntity.ok(Map.of("result", result.toString()));
		} catch (ArithmeticException e) {
            return ResponseEntity.badRequest().body(Map.of("error", "Overflow error occurred"));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(Map.of("error", "Server error"));
        }
    }
}
