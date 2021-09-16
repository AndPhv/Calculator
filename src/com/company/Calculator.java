package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener
{
    //Создание кнопки
//        setLayout(null); // размещение элементов на панели на любых координатах
//
//        JButton b1 = new JButton("123"); // инициализация всех кнопок, в скобках указывается что будет напечатано на кнопке
//        b1.setBounds(100, 100, 80, 50); // размер кнопки (по Х, по Y, по ширине, по высоте)
//        add(b1); // добавление нашей кнопки

    JFrame frame;
    JTextField textField;
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[13];
    JButton addButton, subButton, mulButton, divButton, sqrtButton, perButton;
    JButton decButton, equButton, delButton, clrButton, negButton, xButton, degButton;
    JPanel panel;

    Font myFont = new Font("Ink Free", Font.BOLD, 20);

    double num1 = 0, num2 = 0, result = 0;
    char operator;

    Calculator()
    {
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 560);
        frame.setLayout(null);

        textField = new JTextField();
        textField.setBounds(50, 25, 319, 50);
        textField.setFont(myFont);
        textField.setEnabled(false);

        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("Delete");
        clrButton = new JButton("C");
        negButton = new JButton("+/-");
        sqrtButton = new JButton("Sqr");
        perButton = new JButton("%");
        xButton = new JButton("1/x");
        degButton = new JButton("x^y");

        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decButton;
        functionButtons[5] = equButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clrButton;
        functionButtons[8] = negButton;
        functionButtons[9] = sqrtButton;
        functionButtons[10] = perButton;
        functionButtons[11] = xButton;
        functionButtons[12] = degButton;

        for (int i = 0; i < 13; i++)
        {
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(myFont);
            functionButtons[i].setFocusable(false);
        }
        for (int i = 0; i < 10; i++)
        {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(false);
            numberButtons[i].setBackground(Color.lightGray);
        }

        negButton.setBounds(50, 430, 71, 65);
        delButton.setBounds(297, 430, 153, 65);
        clrButton.setBounds(132, 430, 153, 65);

        clrButton.setBackground(Color.RED);

        panel = new JPanel();
        panel.setBounds(50, 100, 400, 300);
        panel.setLayout(new GridLayout(4, 5, 10, 10));
        //panel.setBackground(Color.);

        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(sqrtButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(perButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);
        panel.add(xButton);
        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(equButton);
        panel.add(divButton);
        panel.add(degButton);

        frame.add(negButton);
        frame.add(panel);
        frame.add(delButton);
        frame.add(clrButton);
        frame.add(textField);
        frame.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        for (int i = 0; i < 10; i++)
        {
            if (e.getSource() == numberButtons[i])
            {
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }
        if (e.getSource() == decButton)
        {
            textField.setText(textField.getText().concat("."));
        }
        if (e.getSource() == addButton)
        {
            num1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("");
        }
        if (e.getSource() == subButton)
        {
            num1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");
        }
        if (e.getSource() == mulButton)
        {
            num1 = Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText("");
        }
        if (e.getSource() == divButton)
        {
            num1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");
        }
        if (e.getSource() == degButton)
        {
            num1 = Double.parseDouble(textField.getText());
            operator = '^';
            textField.setText("");
        }
        if (e.getSource() == xButton)
        {
            num1 = Double.parseDouble(textField.getText());
            result = 1 / num1;
            textField.setText(String.valueOf(result));
        }
        if (e.getSource() == sqrtButton)
        {
            num1 = Double.parseDouble(textField.getText());
            result = Math.sqrt(num1);
            textField.setText(String.valueOf(result));
        }
        if (e.getSource() == equButton)
        {
            num2 = Double.parseDouble(textField.getText());

            switch (operator)
            {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    result = num1 / num2;
                    break;
                case '^':
                    result = Math.pow(num1, num2);
                    break;
            }
            textField.setText(String.valueOf(result));
            num1 = result;
        }
        if (e.getSource() == perButton)
        {
            num1 = Double.parseDouble(textField.getText());
            result /= 100;
            textField.setText(String.valueOf(result));
        }
        if (e.getSource() == clrButton)
        {
            textField.setText("");
        }
        if (e.getSource() == delButton)
        {
            String string = textField.getText();
            textField.setText("");
            for (int i = 0; i < string.length() - 1; i++)
            {
                textField.setText(textField.getText() + string.charAt(i));
            }
        }
        if (e.getSource() == negButton)
        {
            double temp = Double.parseDouble(textField.getText());
            temp *= -1;
            textField.setText(String.valueOf(temp));
        }
    }
}
