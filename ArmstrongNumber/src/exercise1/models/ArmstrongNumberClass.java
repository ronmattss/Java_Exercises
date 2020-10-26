package exercise1.models;

import java.util.*;

public class ArmstrongNumberClass {
	
	// Creating a Singleton Class
	// So that we don't need to create a new object
	// when we need to compute 
	// Clean Code
	private static ArmstrongNumberClass instance = null;
	Stack<Integer> digitStack = new Stack<Integer>();
	ArrayList<Integer> separatedDigitsList = new ArrayList<Integer>();
	
	private ArmstrongNumberClass() {}
	
	
	
	public static ArmstrongNumberClass getInstance()
	{
		if(instance == null)
		{
			instance = new ArmstrongNumberClass();
		}
		return instance;
	}
	
	private int getDigit(int _value)
	{
		return _value % 10;
	}
	
	private void seperateDigits(int _value)
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
		seperateDigits(_value);
		int power = findOrderLength();
		int finalValue = 0;
		
		separatedDigitsList = orderDigits(digitStack);
		
		for(int i =0; i<separatedDigitsList.size();i++)
		{
			int tempValue = (int) Math.pow(separatedDigitsList.get(i), power);
			separatedDigitsList.set(i,tempValue);
		}
		
		for(int i =0; i< separatedDigitsList.size();i++)
		{
			finalValue += separatedDigitsList.get(i);
		}
		System.out.println("initial value: "+_value);
		System.out.println("final value: "+finalValue);

		if(finalValue == _value) {
			System.out.println("It is an Armstrong Number");
		return true;}
		else {
			System.out.println("It is not an Armstrong Number");
		return false;
	}}
	
	
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
