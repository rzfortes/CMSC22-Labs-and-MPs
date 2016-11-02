package calculator;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigInteger;

import javax.swing.*;

public class Calculator extends JFrame implements ActionListener {
    
    JTextField txtArea = new JTextField();
    JButton button1 = new JButton("1");
    JButton button2 = new JButton("2");
    JButton button3 = new JButton("3");
    JButton button4 = new JButton("4");
    JButton button5 = new JButton("5");
    JButton button6 = new JButton("6");
    JButton button7 = new JButton("7");
    JButton button8 = new JButton("8");
    JButton button9 = new JButton("9");
    JButton button0 = new JButton("0");
    JButton buttonAC = new JButton("AC");
    JButton buttonPosNeg = new JButton("+/-");
    JButton buttonPercent = new JButton("%");
    JButton divButton = new JButton("/");
    JButton mulButton = new JButton("x");
    JButton subButton = new JButton("-");
    JButton addButton = new JButton("+");
    JButton equalsButton = new JButton("=");
    JButton dotButton = new JButton(".");
    JButton blankButton = new JButton();
    
    private BigInteger ans;
    private BigInteger num;
    private BigInteger num2;
    private int flag = 0;
    private int operator = 0;
            
    public Calculator() {
        //setLayout(new FlowLayout());
        JFrame frame = new JFrame("Calculator");
        frame.setSize(300, 400);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setBackground(Color.white);
        
        txtArea.setBackground(Color.gray);
        txtArea.setForeground(Color.black);
        txtArea.setHorizontalAlignment(JTextField.RIGHT);
        txtArea.setPreferredSize(new Dimension(150, 80));
        txtArea.setFont(new Font("Calibri", Font.BOLD, 26));
        txtArea.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.white));
        frame.add(txtArea, BorderLayout.NORTH);
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5,5));
        buttonPanel.setBackground(Color.darkGray);

        
        frame.add(buttonPanel, BorderLayout.CENTER);
        
        buttonAC.setBackground(Color.gray);
        buttonAC.setForeground(Color.black);
        buttonPanel.add(buttonAC);
        buttonPosNeg.setBackground(Color.gray);
        buttonPosNeg.setForeground(Color.black);
        buttonPanel.add(buttonPosNeg);
        buttonPercent.setBackground(Color.gray);
        buttonPercent.setForeground(Color.black);
        buttonPanel.add(buttonPercent);
        divButton.setBackground(Color.orange);
        divButton.setForeground(Color.white);
        buttonPanel.add(divButton);
        button7.setBackground(Color.gray);
        button7.setForeground(Color.black);
        buttonPanel.add(button7);
        button8.setBackground(Color.gray);
        button8.setForeground(Color.black);
        buttonPanel.add(button8);
        button9.setBackground(Color.gray);
        button9.setForeground(Color.black);
        buttonPanel.add(button9);
        mulButton.setBackground(Color.orange);
        mulButton.setForeground(Color.white);
        buttonPanel.add(mulButton);
        button4.setBackground(Color.gray);
        button4.setForeground(Color.black);
        buttonPanel.add(button4);
        button5.setBackground(Color.gray);
        button5.setForeground(Color.black);
        buttonPanel.add(button5);
        button6.setBackground(Color.gray);
        button6.setForeground(Color.black);
        buttonPanel.add(button6);
        subButton.setBackground(Color.orange);
        subButton.setForeground(Color.white);
        buttonPanel.add(subButton); 
        button1.setBackground(Color.gray);
        button1.setForeground(Color.black);
        buttonPanel.add(button1);
        button2.setBackground(Color.gray);
        button2.setForeground(Color.black);
        buttonPanel.add(button2);
        button3.setBackground(Color.gray);
        button3.setForeground(Color.black);
        buttonPanel.add(button3);
        addButton.setBackground(Color.orange);
        addButton.setForeground(Color.white);
        buttonPanel.add(addButton);
        blankButton.setBackground(Color.gray);
        blankButton.setForeground(Color.black);
        buttonPanel.add(blankButton);
        button0.setBackground(Color.gray);
        button0.setForeground(Color.black);
        buttonPanel.add(button0);
        dotButton.setBackground(Color.gray);
        dotButton.setForeground(Color.black);
        buttonPanel.add(dotButton);
        equalsButton.setBackground(Color.orange);
        equalsButton.setForeground(Color.white);
        buttonPanel.add(equalsButton);
        frame.setVisible(true);

        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);
        button4.addActionListener(this);
        button5.addActionListener(this);
        button6.addActionListener(this);
        button7.addActionListener(this);
        button8.addActionListener(this);
        button9.addActionListener(this);
        button0.addActionListener(this);
        buttonAC.addActionListener(this);
        buttonPosNeg.addActionListener(this);
        buttonPercent.addActionListener(this);
        divButton.addActionListener(this);
        mulButton.addActionListener(this);
        subButton.addActionListener(this);
        addButton.addActionListener(this);
        equalsButton.addActionListener(this);
        dotButton.addActionListener(this);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if((e.getSource() == button1) 
        || (e.getSource() == button2)
        || (e.getSource() == button3)
        || (e.getSource() == button4)
        || (e.getSource() == button5)
        || (e.getSource() == button6)
        || (e.getSource() == button7)
        || (e.getSource() == button8)
        || (e.getSource() == button9)
        || (e.getSource() == button0)) {
            // gets the text from the button already
            String digit = e.getActionCommand();

            // appends the numbers of digit pressed
            txtArea.setText(txtArea.getText() + digit);
        } else {
            //txtArea.setText("num = " + num);
            
            // clears the textfield
            if(e.getSource() == buttonAC) {
                txtArea.setText("");
                flag = 0;
                num = new BigInteger("0");
                num2 = new BigInteger("0");
                ans = new BigInteger("0");
            }
            if(e.getSource() == buttonPosNeg) {
                BigInteger val = new BigInteger(txtArea.getText());
                if(val != BigInteger.valueOf(0)) {
                    val = val.multiply(BigInteger.valueOf(-1));
                    txtArea.setText("" + val);
                }
            }
            if(e.getSource() == buttonPercent) {
                txtArea.setText(buttonPercent.getText());
            }
            if(e.getSource() == divButton) {
                num = new BigInteger(txtArea.getText());
                operator = 4;
                txtArea.setText("" + num + " / ");
            }
            if(e.getSource() == mulButton) {
                num = new BigInteger(txtArea.getText());
                operator = 3;
                txtArea.setText("" + num + " * ");
            }
            if(e.getSource() == subButton) {
                num = new BigInteger(txtArea.getText());
                operator = 2;
                txtArea.setText("" + num + " - ");
            }
            if(e.getSource() == addButton) {
                num = new BigInteger(txtArea.getText());
                operator = 1;
                txtArea.setText("" + num + " + ");
            }
            if(e.getSource() == equalsButton) {
                flag++;
                if(flag == 1) {
                    String s = String.valueOf(num);
                    txtArea.setText(txtArea.getText().substring(s.length() + 3, txtArea.getText().length()));
                    num2 = new BigInteger(txtArea.getText());
                } 
                
                switch(operator) {
                    case 1: 
                        ans = num.add(num2);
                        break;
                    case 2:
                        ans = num.subtract(num2);
                        break;
                    case 3:
                        ans = num.multiply(num2);
                        break;
                    case 4:
                        ans = num.divide(num2);
                        break;
                    default:
                        break;
                }
                txtArea.setText(""+ ans);
            }
            if(e.getSource() == dotButton) {
                txtArea.setText(dotButton.getText());
                // error
                //txtArea.setText(txtArea.getText() + ".");
            }
            
        }
        
    }

    public static void main(String[] args) {
            // TODO Auto-generated method stub
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    Calculator calcu = new Calculator();
                }
            });
    }

}