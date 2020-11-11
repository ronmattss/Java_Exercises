package com.shadedgames.helpers;

import java.util.Stack;

public class Postfix {

    //check the operators precedence
    int precedence(char ch)
    {
        return switch (ch) {
            case '+', '-' -> 1;
            case '*', '/' -> 2;
            case '^' -> 3;
            default -> -1;
        };
        // return -1 if it is an invalid operator
    }

    public String infixToPostfix (String exp)
    {
        String result = "";

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i<exp.length(); i++)
        {
            char c = exp.charAt(i);

            // If the scanned character is an operand, add it to output.
            if (Character.isLetterOrDigit(c))
                result += c;

                // If the scanned character is an '(', push it to the stack.
            else if (c == '(')
                stack.push(c);

            else if (c == ')')
            {
                while (!stack.isEmpty() && stack.peek() != '(')
                    result += stack.pop();

                if (!stack.isEmpty() && stack.peek() != '(')
                    return "Invalid Expression"; // invalid expression
                else
                    stack.pop();
            }

            else // an operator is encountered
            {
                while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek())){
                    if(stack.peek() == '(')
                        return "Invalid Expression";
                    result += stack.pop();
                }
                stack.push(c);
            }
        }

        // pop all the operators from the stack
        while (!stack.isEmpty()){
            if(stack.peek() == '(')
                return "Invalid Expression";
            result += stack.pop();
        }
        return result;
    }


    public int evaluate (String exp)
    {
        // tokens are the operands and operators
        char[] tokens = exp.toCharArray();

        // Stack for digits
        Stack<Integer> digits = new Stack<Integer>();

        // Stack for Operators
        Stack<Character> ops = new Stack<Character>();

        for (int i = 0; i < tokens.length; i++)
        {
            // Current token is a whitespace, skip it
            if (tokens[i] == ' ')
                continue;

            // Current token is a number, push it to stack for numbers
            if (tokens[i] >= '0' && tokens[i] <= '9')
            {
                StringBuffer sbuf = new StringBuffer();
                // There may be more than one digits in number
                int j = i;
                while (j < tokens.length && tokens[j] >= '0' && tokens[j] <= '9') {

                    sbuf.append(tokens[j++]);
                }
                digits.push(Integer.parseInt(sbuf.toString()));
            }

            // Current token is an opening brace, push it to 'ops'
            else if (tokens[i] == '(')
                ops.push(tokens[i]);

                // Closing brace encountered, solve entire brace
            else if (tokens[i] == ')')
            {
                while (ops.peek() != '(')
                    digits.push(applyOp(ops.pop(), digits.pop(), digits.pop()));
                ops.pop();
            }

            // Current token is an operator.
            else if (tokens[i] == '^' || tokens[i] == '+' || tokens[i] == '-' || tokens[i] == '*' || tokens[i] == '/')
            {

                while (!ops.empty() && hasPrecedence(tokens[i], ops.peek()))
                    digits.push(applyOp(ops.pop(), digits.pop(), digits.pop()));

                ops.push(tokens[i]);
            }
        }


        while (!ops.empty())
            digits.push(applyOp(ops.pop(), digits.pop(), digits.pop()));


        return digits.pop();
    }

    // Returns true if 'op2' has higher or same precedence as 'op1',
    // otherwise returns false.
    public static boolean hasPrecedence(char op1, char op2)
    {
        if (op2 == '(' || op2 == ')')
            return false;
        if (op1 == '^')
            return false;
        if (( op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-'))
            return false;
        else
            return true;
    }

    //  method to apply an operator 'op' on operands 'a'
    // and 'b'. Return the result.
    public static int applyOp(char op, int b, int a)
    {
        switch (op)
        {
            case '+':
                return a + b;
            case '^':
                return (int) Math.pow(a, b);
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
