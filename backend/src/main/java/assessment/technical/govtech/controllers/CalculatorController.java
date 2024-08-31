package assessment.technical.govtech.controllers;

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
    public ResponseEntity<Long> addTwoNumbers(long firstNumber, long secondNumber) {
        return ResponseEntity.ok(calculatorService.addTwoNumbers(firstNumber, secondNumber));
    }
	
	@PostMapping(
		value = "/subtract", 
		consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, 
		produces = MediaType.APPLICATION_JSON_VALUE
	)
    public ResponseEntity<Long> subtractTwoNumbers(long firstNumber, long secondNumber) {
		return ResponseEntity.ok(calculatorService.subtractTwoNumbers(firstNumber, secondNumber));
    }
}
