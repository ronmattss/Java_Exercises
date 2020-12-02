package exercise1.models;

import java.util.*;

public class ArmstrongNumberClass {
	
	// Singleton Class
	// So that we don't need to create a new object
	private static ArmstrongNumberClass instance = null;
	Stack<Integer> digitStack = new Stack<Integer>();
	ArrayList<Integer> separatedDigitsList = new ArrayList<Integer>();
	
	private ArmstrongNumberClass() {}
	
	
	// Using Singleton Pattern
	// this is here so that we can return the instance of this class without  creating a new instance
	public static ArmstrongNumberClass getInstance()
	{
		if(instance == null)
		{
			instance = new ArmstrongNumberClass();
		}
		return instance;
	}
	// Algorithm
	/*
	 * ArmstrongNumberClass
	 *
    Find the total order(number of digits) of the given number.
    For each digit d, find d raised to the power of o where o is the order(total number of digits) calculated in Step 1.
    Compare sum of all such values with the given number.Return true if equal,false otherwise.
	 *
	 *
	 * */

	// this function just returns the value of a given digit
	private int getDigit(int _value)
	{
		return _value % 10;
	}

	//
	private void separateDigits(int _value)
	{
		int value = _value;
		while(value>0)
		{
			digitStack.add(getDigit(value));
			value = value/10;
		}
		System.out.println();
	}
	
	
	private int findOrderLength()
	{
		return digitStack.size();
	}
	
	
	// Why is there a Stack?
	// to reorder the digits to it's original order
	// since 
	private ArrayList<Integer> orderDigits(Stack<Integer> _digitStack)
	{
		ArrayList<Integer> _digits = new ArrayList<Integer>();
		while(!_digitStack.isEmpty())
		{
			_digits.add(_digitStack.pop());
		}
		return _digits;
	}
	
	public boolean checkIfArmstrongNumber(int _value)
	{
		separateDigits(_value);			// Step 1 separate all digits, digits are stored in a stack
		int power = findOrderLength();//3  // Step 2 find digit length (switch to 3 if required), for flexibility based on google's definition of Armstrong number, power = to the total length of digit
		int finalValue = 0;				// final value

		separatedDigitsList = orderDigits(digitStack); // extra step to reorder all digits
		//Step 3 raised each digit by power
		for(int i =0; i<separatedDigitsList.size();i++)
		{
			int tempValue = (int) Math.pow(separatedDigitsList.get(i), power);
			separatedDigitsList.set(i,tempValue);
		}
		//Step 4 add all digits
		for(int i =0; i< separatedDigitsList.size();i++)
		{
			finalValue += separatedDigitsList.get(i);
		}
		System.out.println("initial value: "+_value);
		System.out.println("final value: "+finalValue);
		// step 5 determine if final value is same as initial value
		if(finalValue == _value) {
			System.out.println("It is an Armstrong Number");
		return true;
		}
		else {
			System.out.println("It is not an Armstrong Number");
		return false;
	}
		}
	
	
	// Algorithm
	/*
	 * ArmstrongNumberClass
	 * 
    Find the total order(number of digits) of the given number.
    For each digit d, find d raised to the power of o where o is the order calculated in Step 1.
    Compare sum of all such values with the given number.Return true if equal,false otherwise.

	 * 
	 * 
	 * */
	
	

}
