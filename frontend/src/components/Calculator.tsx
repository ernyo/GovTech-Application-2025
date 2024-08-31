import { useState } from 'react';
import { addTwoNumbers, subtractTwoNumbers } from '../services/CalculatorService';

const Calculator = () => {
  const [firstNumber, setFirstNumber] = useState('');
  const [secondNumber, setSecondNumber] = useState('');
  const [result, setResult] = useState(null);

  const handleAdd = async () => {
    const number1 = firstNumber ? parseFloat(firstNumber) : 0;
    const number2 = secondNumber ? parseFloat(secondNumber) : 0;
    const result = await addTwoNumbers(number1, number2)
    setResult(result)
  };

  const handleSubtract = async () => {
    const number1 = firstNumber ? parseFloat(firstNumber) : 0;
    const number2 = secondNumber ? parseFloat(secondNumber) : 0;
    const result = await subtractTwoNumbers(number1, number2)
    setResult(result)
  };

  return (
    <div style={{ textAlign: 'center' }}>
      <h1>Simple Calculator</h1>
      <input
        type="number"
        placeholder="Enter first number"
        value={firstNumber}
        onChange={(e) => setFirstNumber(e.target.value)}
      />
      <br />
      <input
        type="number"
        placeholder="Enter second number"
        value={secondNumber}
        onChange={(e) => setSecondNumber(e.target.value)}
      />
      <br />
      <button onClick={handleAdd}>Add</button>
      <button onClick={handleSubtract}>Subtract</button>
      <div>
        {result !== null && <h2>Result: {result}</h2>}
      </div>
    </div>
  );
};

export default Calculator;
