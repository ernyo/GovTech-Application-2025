import { useState } from 'react';
import { addTwoNumbers, subtractTwoNumbers } from '../services/CalculatorService';

const Calculator = () => {
  const [firstNumber, setFirstNumber] = useState('');
  const [secondNumber, setSecondNumber] = useState('');
  const [result, setResult] = useState<string | null>(null);
  const [error, setError] = useState<string | null>(null);

  const handleAdd = async () => {
    setError(null); // Reset error before new operation
    try {
      const { result, error } = await addTwoNumbers(firstNumber, secondNumber);

      if (error) {
        setError(error); 
      } else if (result) {
        setResult(result);
      }

    } catch (err) {
      setError('Error occurred during addition. Check input values.');
    }
  };

  const handleSubtract = async () => {
    setError(null); // Reset error before new operation
    try {
      const { result, error } = await subtractTwoNumbers(firstNumber, secondNumber);

      if (error) {
        setError(error); 
      } else if (result) {
        setResult(result);
      }
    } catch (err) {
      setError('Error occurred during subtraction. Check input values.');
    }
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
        {result && <h2>Result: {result}</h2>}
        {error && <p>Error: {error}</p>}
      </div>
    </div>
  );
};

export default Calculator;
