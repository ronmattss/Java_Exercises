package exercise1;

import java.util.*;

import exercise1.models.ArmstrongNumberClass;

public class ProgramClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Execute It Here
		
		// Tested in JUnit
		// ArmstrongNumberClass.getInstance().checkIfArmstrongNumber(406);
		
		char choice = 'y';

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
