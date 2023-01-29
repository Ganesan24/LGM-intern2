import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.text.DecimalFormat;

public class ScientificCalculator extends JFrame {
    // Create the buttons and text field
    private JTextField displayField;
    private JButton button0;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JButton button7;
    private JButton button8;
    private JButton button9;
    private JButton buttonAdd;
    private JButton buttonSubtract;
    private JButton buttonMultiply;
    private JButton buttonDivide;
    private JButton buttonEquals;
    private JButton buttonDecimal;
    private JButton buttonClear;
    private JButton buttonSin;
    private JButton buttonCos;
    private JButton buttonTan;
    private JButton buttonLog;
    private JButton buttonSqrt;
    private JButton buttonPower;
    private JButton buttonInverse;

    // Create the variables to store the operands and operation
    private double operand1;
    private double operand2;
    private String operation;
    private boolean startNumber;
    private boolean operationEntered;

    public ScientificCalculator() {
        // Set the title, layout and default close operation
        super("Scientific Calculator");
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create the display field
        displayField = new JTextField(30);
        displayField.setEditable(false);
        add(displayField);

        // Create the number buttons
        button0 = new JButton("0");
        System.out.println();
        button1 = new JButton("1");
        button2 = new JButton("2");
        button3 = new JButton("3");
        button4 = new JButton("4");
        button5 = new JButton("5");
        button6 = new JButton("6");
        button7 = new JButton("7");
        button8 = new JButton("8");
        button9 = new JButton("9");
        buttonDecimal = new JButton(".");
        buttonClear = new JButton("Clear");

        // Create the operation buttons
        buttonAdd = new JButton("+");
        buttonSubtract = new JButton("-");
        buttonMultiply = new JButton("*");
        buttonDivide = new JButton("/");
        buttonEquals = new JButton("=");
        buttonSin = new JButton("Sin");
        buttonCos = new JButton("Cos");
        buttonTan = new JButton("Tan");
        buttonLog = new JButton("Log");
        buttonSqrt = new JButton("Sqrt");
        buttonPower = new JButton("x^y");
        buttonInverse = new JButton("1/x");

        // Add the number buttons to the calculator
       
          // Set the title, layout and default close operation
        
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
        // Create the display field
        displayField = new JTextField(30);
        displayField.setEditable(false);
        add(displayField);
    
        // Create the number buttons
        button0 = new JButton("0");
        System.out.println();
        button1 = new JButton("1");
        button2 = new JButton("2");
        button3 = new JButton("3");
        button4 = new JButton("4");
        button5 = new JButton("5");
        button6 = new JButton("6");
        button7 = new JButton("7");
        button8 = new JButton("8");
        button9 = new JButton("9");
        buttonDecimal = new JButton(".");
        buttonClear = new JButton("Clear");
    
        // Create the operation buttons
        buttonAdd = new JButton("+");
        buttonSubtract = new JButton("-");
        buttonMultiply = new JButton("*");
        buttonDivide = new JButton("/");
        buttonEquals = new JButton("=");
        buttonSin = new JButton("Sin");
        buttonCos = new JButton("Cos");
        buttonTan = new JButton("Tan");
        buttonLog = new JButton("Log");
        buttonSqrt = new JButton("Sqrt");
        buttonPower = new JButton("x^y");
        buttonInverse = new JButton("1/x");
    
        // Add the number buttons to the calculator
        add(button7);
        add(button8);
        add(button9);
       
            add(button4);
            add(button5);
            add(button6);
            add(button1);
            add(button2);
            add(button3);
            add(button0);
            add(buttonDecimal);
        
            // Add the operation buttons to the calculator
            add(buttonAdd);
            add(buttonSubtract);
            add(buttonMultiply);
            add(buttonDivide);
            add(buttonSin);
            add(buttonCos);
            add(buttonTan);
            add(buttonLog);
            add(buttonSqrt);
            add(buttonPower);
            add(buttonInverse);
            add(buttonEquals);
            add(buttonClear);
        
            // Add ActionListeners to the buttons
            button0.addActionListener(new NumberListener());
            button1.addActionListener(new NumberListener());
            button2.addActionListener(new NumberListener());
            button3.addActionListener(new NumberListener());
            button4.addActionListener(new NumberListener());
            button5.addActionListener(new NumberListener());
            button6.addActionListener(new NumberListener());
            button7.addActionListener(new NumberListener());
            button8.addActionListener(new NumberListener());
            button9.addActionListener(new NumberListener());
            buttonDecimal.addActionListener(new NumberListener());
            buttonAdd.addActionListener(new OperationListener());
            buttonSubtract.addActionListener(new OperationListener());
            buttonMultiply.addActionListener(new OperationListener());
            buttonDivide.addActionListener(new OperationListener());
            buttonSin.addActionListener(new OperationListener());
            buttonCos.addActionListener(new OperationListener());
            buttonTan.addActionListener(new OperationListener());
            buttonLog.addActionListener(new OperationListener());
            buttonSqrt.addActionListener(new OperationListener());
            buttonPower.addActionListener(new OperationListener());
            buttonInverse.addActionListener(new OperationListener());
            buttonEquals.addActionListener(new OperationListener());
            buttonClear.addActionListener(new ClearListener());
        
            // Pack and set the calculator visible
            pack();
            setVisible(true);
        }
        
        // NumberListener for the number buttons
        private class NumberListener implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                JButton source = (JButton) e.getSource();
                String digit = source.getText();
                if (startNumber) {
                    displayField.setText(digit);
                    startNumber = false;
                } else {
                    displayField.setText(displayField.getText() + digit);
                }
            }
        }
        
        // OperationListener for the operation buttons
        private class OperationListener implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                JButton source = (JButton) e.getSource();
                String command = source.getText();
                if (!operationEntered) {
                    operand1 = Double.parseDouble(displayField.getText());
                    operation = command;
                    operationEntered = true;
                    startNumber = true;
                } else {
                    operand2 = Double.parseDouble(displayField.getText());
                    if (operation.equals("+")) {
                        operand1 += operand2;
                    } else if (operation.equals("-")) {
                        operand1 -= operand2;
                    } else if (operation.equals("*")) {
                        operand1 *= operand2;
                    } else if (operation.equals("/")) {
                        operand1 /= operand2;
                    } else if (operation.equals("Sin")) {
                        operand1 = Math.sin(operand2);
                    } else if (operation.equals("Cos")) {
                        operand1 = Math.cos(operand2);
                    } else if (operation.equals("Tan")) {
                        operand1 = Math.tan(operand2);
                    } else if (operation.equals("Log")) {
                        operand1 = Math.log10(operand2);
                    } else if (operation.equals("Sqrt")) {
                        operand1 = Math.sqrt(operand2);
                    } else if (operation.equals("x^y")) {
                        operand1 = Math.pow(operand1, operand2);
                    } else if (operation.equals("1/x")) {
                        operand1 = 1 / operand2;
                    }
                    displayField.setText("" + operand1);
                    operationEntered = false;
                    startNumber = true;
                }
            }
        }
        
        // ClearListener for the clear button
        private class ClearListener implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                operand1 = 0;
                operand2 = 0;
                operation = "";
                displayField.setText("");
                operationEntered = false;
                startNumber = true;
            }
        }
        
        public static void main(String[] args) {
            new ScientificCalculator();
        }
        }
        
        
        
