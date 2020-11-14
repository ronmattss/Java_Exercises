import com.shadedgames.helpers.Postfix;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        Postfix operate = new Postfix();
        @Override
        public void actionPerformed(ActionEvent e) {
           value =  textArea.getText();
            int result = operate.evaluate(value);
             textArea.setText(value+" = "+ String.valueOf(result));
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
