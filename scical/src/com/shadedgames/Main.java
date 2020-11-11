package com.shadedgames;

import com.shadedgames.helpers.Postfix;

import java.util.*;

public class Main {

    public static void main(String[] args) {
	// weeee main calculator entry point
        System.out.println("Enter an Expression: ");
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
    }
}
