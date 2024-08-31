import axios from "../api/axios";

export const addTwoNumbers = async (firstNumber: number, secondNumber: number) => {
    try {
        const response = await axios.post('/add', 
            { firstNumber: firstNumber, secondNumber: secondNumber }
        );
        if (response.status === 200) {
            console.log(response)
            return response.data
        }
    } catch (error) {
        console.error('Error occurred while adding:', error);
    }
}

export const subtractTwoNumbers = async (firstNumber: number, secondNumber: number) => {
    try {
        const response = await axios.post('/subtract', 
            { firstNumber: firstNumber, secondNumber: secondNumber }
        );
        if (response.status === 200) {
            return response.data
        }
    } catch (error) {
        console.error('Error occurred while subtracting:', error);
    }
}