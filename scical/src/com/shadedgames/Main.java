package com.shadedgames;

import com.shadedgames.helpers.Postfix;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        // weeee main calculator entry point
        //TODO: Do App Dev Requirements
        // manual input of digits and operands.
        // Requirements:
        /*
         * number of inputs range from 2 - 10
         * operation depends on number of inputs
         * + and - values int double is accepted
         * other inputs aside from operators and operands are considered Invalid Input
         * Follow MDAS Rule
         * */

        ArrayList<Object> expression = new ArrayList<Object>();
        Postfix expressionSolver = new Postfix();
        int inputLength;
        boolean flag;
        Scanner input = new Scanner(System.in);
        do {
            try {
                System.out.print("Enter Number of Inputs: ");
                inputLength = input.nextInt();
                if (inputLength < 2|| inputLength >10) {
                    throw new Exception("Input length must be greater than 1");
                } else {

                    for (int i = 0; i < inputLength; i++) {
                        String stream;
                        System.out.print("Enter " + (i+1) + num(i + 1) + " Number:");
                        stream = input.next();
                        if (tryParseDouble(stream)) {
                            expression.add(Double.parseDouble(stream));
                        } else {
                            throw new Exception("Invalid Input");
                        }
                        if (i != inputLength - 1) {
                            System.out.print("Enter Expression: ");
                            stream = input.next();
                            if (stream.equalsIgnoreCase("^") || stream.equalsIgnoreCase("+") || stream.equalsIgnoreCase("-") || stream.equalsIgnoreCase("*") || stream.equalsIgnoreCase("/")) {
                                expression.add(stream);
                            }
                            else
                            {
                                throw new Exception("Invalid Input");
                            }
                        }
                    }
                }
            } catch (Exception e) {
                System.out.println("Invalid Input");
                break;
            }
            System.out.println("Result: "+expressionSolver.evaluateObjectList(expression));
            expression.clear();
            System.out.println("Do you want to try again? (y/n)");
            if (input.next().equalsIgnoreCase("y"))
                flag = true;
            else
                flag = false;

        } while (flag);
        input.close();

       /* System.out.println("Enter an Expression: ");
        Scanner sc = new Scanner(System.in);
        boolean choice = true;
        while(choice) {
            // postfix class has the stack inplementation
            Postfix pf = new Postfix();
            String s = sc.nextLine();

            //	System.out.println(pf.infixToPostfix(s));
            System.out.println(pf.evaluate(s));

            System.out.println("\nAgain (y/n): ");

            String a = sc.next();

            if(a.equalsIgnoreCase("y"))
                choice = true;
            else
                choice = false;

        }
        sc.close();
    }*/
    }

    static String num(int value) {
        switch (value) {
            case 1:
                return "st";
            case 2:
                return "nd";
            case 3:
                return "rd";
            default:
                return "th";
        }
    }

    static boolean tryParseDouble(String value) {
        try {
            Double.parseDouble(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
