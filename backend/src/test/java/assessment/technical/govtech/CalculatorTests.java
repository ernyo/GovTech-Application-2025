package assessment.technical.govtech;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import assessment.technical.govtech.controllers.CalculatorController;
import assessment.technical.govtech.services.CalculatorService;

@WebMvcTest(CalculatorController.class)
class CalculatorTests {

	@Autowired
    private MockMvc mockMvc;

    @MockBean
    private CalculatorService calculatorService;

    @Test
    public void testAddNumbers() throws Exception {
        when(calculatorService.addTwoNumbers(10, 5)).thenReturn(15L);

        mockMvc.perform(post("/add")
                .contentType("application/x-www-form-urlencoded")
                .param("firstNumber", "10")
                .param("secondNumber", "5"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").value(15));
    }

    @Test
    public void testSubtractNumbers() throws Exception {
        when(calculatorService.subtractTwoNumbers(10, 5)).thenReturn(5L);

        mockMvc.perform(post("/subtract")
                .contentType("application/x-www-form-urlencoded")
                .param("firstNumber", "10")
                .param("secondNumber", "5"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").value(5));
    }
    
}
