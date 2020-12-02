package exercise1;

import java.util.*;

import exercise1.models.ArmstrongNumberClass;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Execute It Here
		
		// Tested in JUnit
		// ArmstrongNumberClass.getInstance().checkIfArmstrongNumber(406);
		// requirements:
		/*
		* it should input any number + or -
		* - numbers and other character should output Invalid output
		*Positive numbers should be identified if armstrong or not
		* do-while loop for retrying
		* */
		char choice = 'y';

		do
		{
			var userInput = new Scanner(System.in);
			System.out.println("Is this an Armstrong Number?");
			System.out.println("Enter a value to check: ");
			ArmstrongNumberClass.getInstance().checkIfArmstrongNumber(userInput.nextInt());

			System.out.println("Try Again?");
			System.out.println("type 'y' to continue or 'n' to exit");
			choice = userInput.next().charAt(0);
		}
		while (choice == 'Y');
		while (choice == 'y') {
			var userInput = new Scanner(System.in);
			System.out.println("Is this an Armstrong Number?");
			System.out.println("Enter a value to check: ");
			ArmstrongNumberClass.getInstance().checkIfArmstrongNumber(userInput.nextInt());

			System.out.println("Try Again?");
			System.out.println("type 'y' to continue or 'n' to exit");
			choice = userInput.next().charAt(0);
		}
		System.out.println("Checker Terminated");

	}

}
