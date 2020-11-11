package com.shadedgames.helpers;

public class OperationHelper {
    // Handles basic Calculator operations
    public float operatorA;
    public float operatorB;
    public String operator;


    public void CalculateTwoOperands()
    {
        switch(operator)
        {
            case "+":
                System.out.println(operatorA + " + "+ operatorB + " = " + (operatorA+operatorB));;
                break;
            case "-":
                System.out.println(operatorA + " - "+ operatorB + " = " + (operatorA-operatorB));;
                break;
            case "*":
                System.out.println(operatorA + " * "+ operatorB + " = " + (operatorA*operatorB));;
                break;
            case "/":
                System.out.println(operatorA + " / "+ operatorB + " = " + (operatorA/operatorB));;
                break;
            case "%":
                System.out.println(operatorA + " % "+ operatorB + " = " + (operatorA%operatorB));;
                break;

            default:
                System.out.println("Invalid Operation");
                break;

        }
    }

}
