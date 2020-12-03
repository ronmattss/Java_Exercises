package com.shadedgames.helpers;

import java.util.ArrayList;
import java.util.Stack;

public class Postfix {


    // Workaround so that it can accept negative values
    // this method originally only accepts positive ints
    // Workaround is to create an ArrayList<Object> :)
    public double evaluateObjectList(ArrayList<Object> listBasedExpression) {
        // tokens are the operands and operators

        ArrayList<Object> listOfObjects = listBasedExpression;
        // ArrayList<Object> tokenList = exp;
        // Stack for digits
        Stack<Double> digits = new Stack<Double>();

        // Stack for Operators
        Stack<Character> ops = new Stack<Character>();

        //region Expression
        // Iterate through te list
        for (int i = 0; i < listOfObjects.size(); i++) {
            // if Current TokenIndex is a Digit
            if (listOfObjects.get(i) instanceof Double || listOfObjects.get(i) instanceof Integer) {
                digits.push((Double) listOfObjects.get(i));
            }
            // Check if current Token is an Operator
            else if (listOfObjects.get(i) instanceof String) {
                String operator = listOfObjects.get(i).toString();
                // if it is a ( push it in the stack
                if (operator == "(") {
                    ops.push(operator.charAt(0));
                }
                else if (operator == ")") // if it is a ) then solve inner operations While not encountering a (
                {
                    while (ops.peek() != '(')
                        digits.push(applyOp(ops.pop(), digits.pop(), digits.pop()));
                    ops.pop();
                } else if (operator.equalsIgnoreCase("^") || operator.equalsIgnoreCase("+") || operator.equalsIgnoreCase("-") || operator.equalsIgnoreCase("*") || operator.equalsIgnoreCase("/")) {

                    while (!ops.empty() && hasPrecedence(operator.charAt(0), ops.peek())) {
                        digits.push(applyOp(ops.pop(), digits.pop(), digits.pop()));
                    }

                    ops.push(operator.charAt(0));
                }
            }
        }
        while (!ops.empty())
            digits.push(applyOp(ops.pop(), digits.pop(), digits.pop()));
        listOfObjects.clear();
        return digits.pop();

    }

    // Returns true if 'op2' has higher or same precedence as 'op1',
    // otherwise returns false.
    public static boolean hasPrecedence(char op1, char op2) {
        if (op2 == '(' || op2 == ')')
            return false;
        if (op1 == '^')
            return false;
        if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-'))
            return false;
        else
            return true;
    }

    //  method to apply an operator 'op' on operands 'a'
    // and 'b'. Return the result.
    public static double applyOp(char op, double b, double a) {
        switch (op) {
            case '+':
                return a + b;
            case '^':
                return Math.pow(a, b);
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                if (b == 0)
                    throw new
                            UnsupportedOperationException("Cannot divide by zero");
                return a / b;
        }
        return 0;
    }

}
