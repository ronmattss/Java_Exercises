import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Stack;

public class Calculator {
    private JPanel panel1;
    private JTextArea textArea1;
    private JTextArea textArea;
    private JButton sevenButton;
    private JButton eightButton;
    private JButton nineButton;
    private JButton fourButton;
    private JButton fiveButton;
    private JButton sixButton;
    private JButton threeButton;
    private JButton twoButton;
    private JButton oneButton;
    private JButton zeroButton;
    private JButton multiplyButton;
    private JButton subtractButton;
    private JButton addButton;
    private JButton divideButton;
    private JButton moduloButton;
    private JButton equalsButton;
    private JButton exponentButton;
    private JButton clearButton;

    public Calculator()
    {
        zeroButton.addActionListener(new NumberBtnClick(zeroButton.getText()));
        oneButton.addActionListener(new NumberBtnClick(oneButton.getText()));
        twoButton.addActionListener(new NumberBtnClick(twoButton.getText()));
        threeButton.addActionListener(new NumberBtnClick(threeButton.getText()));
        fourButton.addActionListener(new NumberBtnClick(fourButton.getText()));
        fiveButton.addActionListener(new NumberBtnClick(fiveButton.getText()));
        sixButton.addActionListener(new NumberBtnClick(sixButton.getText()));
        sevenButton.addActionListener(new NumberBtnClick(sevenButton.getText()));
        eightButton.addActionListener(new NumberBtnClick(eightButton.getText()));
        nineButton.addActionListener(new NumberBtnClick(nineButton.getText()));
        subtractButton.addActionListener(new NumberBtnClick(subtractButton.getText()));
        addButton.addActionListener(new NumberBtnClick(addButton.getText()));
        divideButton.addActionListener(new NumberBtnClick(divideButton.getText()));
        moduloButton.addActionListener(new NumberBtnClick(moduloButton.getText()));
        multiplyButton.addActionListener(new NumberBtnClick(multiplyButton.getText()));
        exponentButton.addActionListener(new NumberBtnClick(exponentButton.getText()));
        equalsButton.addActionListener(new EqualsClicked());
        clearButton.addActionListener(new ClearClicked());


    }
    private class NumberBtnClick implements ActionListener
    {
        private String val;
        NumberBtnClick(String value)
        {
            val = value;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
        textArea.setText(textArea.getText()+""+val);
        }
    }
    private class EqualsClicked implements ActionListener
    {
        String value;
        @Override
        public void actionPerformed(ActionEvent e) {
           value =  textArea.getText();
            int result = evaluate(value);
             textArea.setText(value+" = "+ String.valueOf(result));
        }

        public int evaluate (String exp)
        {
            // tokens are the operands and operators
            char[] tokens = exp.toCharArray();

            // Stack for digits
            Stack<Integer> digits = new Stack<Integer>();

            // Stack for Operators
            Stack<Character> ops = new Stack<Character>();

            //region Expression Reading
            for (int i = 0; i < tokens.length; i++)
            {
                // Current token is a whitespace, skip it
                if (tokens[i] == ' ')
                    continue;
                if(Character.isDigit(tokens[i]))    // IF current token is a digit then process it
                {
                    StringBuffer sbuf = new StringBuffer();
                    ArrayList<Character> digChar = new ArrayList<Character>();
                    int j = i;
                    while (j < tokens.length && Character.isDigit(tokens[j]))
                    {
                        sbuf.append(tokens[j++]);
                        System.out.println(" sbuf: "+sbuf.length() + " "+ sbuf.toString()+" ListLength: "+ digChar.size() + "current index; "+j);
                    }

                    System.out.println("when this happened counters j i " + j+ " " + i);
                    digits.push(Integer.parseInt(sbuf.toString()));
                    i=--j;
                }

                // Current token is an opening brace, push it to 'ops'
                else if (tokens[i] == '(')
                    ops.push(tokens[i]);

                    // Closing brace encountered, solve entire brace
                    // Solve all terms inside a brace
                else if (tokens[i] == ')')
                {
                    while (ops.peek() != '(')
                        digits.push(applyOp(ops.pop(), digits.pop(), digits.pop()));
                    ops.pop();
                }

                // Current token is an operator.
                else if (tokens[i] == '^' || tokens[i] == '+' || tokens[i] == '-' || tokens[i] == '*' || tokens[i] == '/')
                {

                    while (!ops.empty() && hasPrecedence(tokens[i], ops.peek())) {
                        digits.push(applyOp(ops.pop(), digits.pop(), digits.pop()));
                    }

                    ops.push(tokens[i]);
                }
            }
            //endregion

            // Do remaining operations
            while (!ops.empty())
                digits.push(applyOp(ops.pop(), digits.pop(), digits.pop()));


            return digits.pop();
        }
        public  boolean hasPrecedence(char op1, char op2)
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
        public  int applyOp(char op, int b, int a)
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
    private class ClearClicked implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) {

            textArea.setText("");
        }
    }


    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculator");
        frame.setContentPane(new Calculator().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }


}
