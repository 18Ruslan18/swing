package com.company;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import static com.company.DrawPanel.*;

public class SimpleGUI extends JFrame {
    private JButton buttonStart = new JButton("Запуск");
    private JButton buttonEditLine = new JButton("Новые отрезки");
    private JButton buttonEditSquare = new JButton("Новое окно");
    private JTextField textField = new JTextField("",5);
    private JLabel label = new JLabel("Input:");
    private JRadioButton radioButton1 = new JRadioButton("Select this");
    private JRadioButton radioButton2 = new JRadioButton("Select that");
    private JCheckBox checkBox = new JCheckBox("Check", false);
    private JPanel container = new JPanel(new GridLayout(1,3,2,2));
    private DrawPanel drawPanel = new DrawPanel(700,700);
    public SimpleGUI(){

        super("Simple Example");
        this.setBounds(300,200,700,700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //container.add(label);
        //container.add(textField);
        ///ButtonGroup buttonGroup = new ButtonGroup();
        //buttonGroup.add(radioButton1);
        //buttonGroup.add(radioButton2);
        //container.add(radioButton1);
        //radioButton1.setSelected(true);
        //container.add(radioButton2);
        //container.add(checkBox);
        buttonStart.addActionListener(new ButtonEventListnerStart());
        container.add(buttonStart);
        buttonEditLine.addActionListener(new ButtonEventListnerLine());
        container.add(buttonEditLine);
        buttonEditSquare.addActionListener(new ButtonEventListnerSquare());
        container.add(buttonEditSquare);
        add(container, BorderLayout.SOUTH);
        add(drawPanel, BorderLayout.CENTER);
    }
class ButtonEventListnerStart implements  ActionListener{
        public void actionPerformed(ActionEvent event){
            JOptionPane.showMessageDialog(null,"Отрезки разделены на 3 вида","Запуск",JOptionPane.PLAIN_MESSAGE);
        }
}
    class ButtonEventListnerSquare implements  ActionListener{
        public void actionPerformed(ActionEvent event){
            DrawPanel.tmp1 =true;
            DrawPanel.tmp2 =false;
            drawPanel = new DrawPanel(700,700);
            JOptionPane.showMessageDialog(null,"Размеры окна изменены","Окно",JOptionPane.PLAIN_MESSAGE);
        }
    }
    class ButtonEventListnerLine implements  ActionListener{
        public void actionPerformed(ActionEvent event){
            DrawPanel.tmp1 =false;
            DrawPanel.tmp2 =true;
            drawPanel = new DrawPanel(700,700);
            JOptionPane.showMessageDialog(null,"Отрезки изменены","Отрезки",JOptionPane.PLAIN_MESSAGE);
        }
    }
}
