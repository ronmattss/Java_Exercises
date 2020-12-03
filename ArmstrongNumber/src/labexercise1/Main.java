package labexercise1;

import java.util.*;

import labexercise1.models.ArmstrongNumber;

public class Main {


    public static void main(String[] args) {
        // requirements:
        /*
         * it should input any number + or -
         * - numbers and other character should output Invalid output
         *Positive numbers should be identified if armstrong or not
         * do-while loop for retrying
         * */
        //char choice = 'y';


        Scanner userInput = new Scanner(System.in);
        String flag;

        do {
            System.out.println("Armstrong number checker");
            System.out.print("Enter number: ");
            String input = userInput.next();
            try {
                if (input.charAt(0) == '-' || !tryParseInt(input)) {
                    throw new InvalidInputException("InvalidInput");
                } else {
                   ArmstrongNumber.getInstance().checkIfArmstrongNumber(Integer.parseInt(input));
                }
            } catch (Exception e) {
                System.out.println("Invalid Input");
            }
            System.out.println("Do you want to try again? (y/n)");
            flag = userInput.next();
            System.out.flush();
        }
        while (flag.equalsIgnoreCase("y"));


    }

    static boolean tryParseInt(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}

class InvalidInputException extends Exception {
    public InvalidInputException(String message) {
        super(message);
    }
}
