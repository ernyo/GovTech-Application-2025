import axios from "../api/axios";

export const addTwoNumbers = async (
    firstNumber: string,
    secondNumber: string
): Promise<{ result?: string; error?: string }> => {
    try {
        // Attempt to convert input strings to BigInt
        const number1 = BigInt(firstNumber);
        const number2 = BigInt(secondNumber);
    
        // Perform the addition
        const sum = await axios.post('/add', 
            { firstNumber: number1, secondNumber: number2 }
        );
    
        // Return the result as a string
        return { result: sum.data.result.toString() };
    } catch (error) {
        // Check if the error is related to BigInt conversion (i.e., invalid input)
        if (error instanceof SyntaxError || error instanceof TypeError) {
            return { error: "Invalid input. Please enter valid numbers." };
        }
    
        // If not, assume it's a server-related issue
        console.error('Server error occurred while adding:', error);
        return { error: "Server error. Please try again later." };
    }
}

export const subtractTwoNumbers = async (
    firstNumber: string,
    secondNumber: string
): Promise<{ result?: string; error?: string }> => {
    try {
        // Attempt to convert input strings to BigInt
        const number1 = BigInt(firstNumber);
        const number2 = BigInt(secondNumber);
    
        // Perform the subtraction
        const difference = await axios.post('/subtract', 
            { firstNumber: number1, secondNumber: number2 }
        );
    
        // Return the result as a string
        return { result: difference.data.result.toString() };
    } catch (error) {
        // Check if the error is related to BigInt conversion (i.e., invalid input)
        if (error instanceof SyntaxError || error instanceof TypeError) {
            return { error: "Invalid input. Please enter valid numbers." };
        }
    
        // If not, assume it's a server-related issue
        console.error('Server error occurred while adding:', error);
        return { error: "Server error. Please try again later." };
    }
}