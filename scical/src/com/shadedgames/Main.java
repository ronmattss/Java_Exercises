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


        ArrayList<Object> isSthisLegal = new ArrayList<Object>();

        isSthisLegal.add(-1.00);
        isSthisLegal.add("-");
        isSthisLegal.add(-2.00);
        isSthisLegal.add("-");
        isSthisLegal.add(-2.00);
        isSthisLegal.add("-");
        isSthisLegal.add(-2.00);
        isSthisLegal.add("-");
        isSthisLegal.add(2.00);
        // SO THIS IS LEGAL HAHAHAHA
        for (int i = 0; i < isSthisLegal.size(); i++) {
            if (isSthisLegal.get(i) instanceof Double)
                System.out.println(isSthisLegal.get(i).toString() + " this is an Integer");
            else {
                System.out.println(isSthisLegal.get(i).toString() + " this is a String");
            }
        }
        for (int i = 0; i<isSthisLegal.size();i++)
        {
            System.out.print(isSthisLegal.get(i).toString() + " ");
        }
        Postfix pf = new Postfix();
        System.out.println("Result: "+pf.evaluateObjectList(isSthisLegal));

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
}
