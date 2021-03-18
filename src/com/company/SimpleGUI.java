package com.company;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class SimpleGUI extends JFrame {
    private JButton button = new JButton("Press");
    private JTextField textField = new JTextField("",5);
    private JLabel label = new JLabel("Input:");
    private JRadioButton radioButton1 = new JRadioButton("Select this");
    private JRadioButton radioButton2 = new JRadioButton("Select that");
    private JCheckBox checkBox = new JCheckBox("Check", false);
    public SimpleGUI(){
        super("Simple Example");
        this.setBounds(100,100,250,100);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container container = this.getContentPane();
        container.setLayout(new GridLayout(3,2,2,2));
        container.add(label);
        container.add(textField);
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(radioButton1);
        buttonGroup.add(radioButton2);
        container.add(radioButton1);
        radioButton1.setSelected(true);
        container.add(radioButton2);
        container.add(checkBox);
        button.addActionListener(new ButtonEventListner());
        container.add(button);
    }
class ButtonEventListner implements  ActionListener{
        public void actionPerformed(ActionEvent event){
            String message ="";
            message += "Button was pressed\n";
            message += "Text is " + textField.getText()+"\n";
            message+= (radioButton1.isSelected() ? "Radio 1" : "Radio 2") + "isSelected\n";
            message+="Checkbox is" + (checkBox.isSelected() ? "checked" : "unchecked");
            JOptionPane.showMessageDialog(null,message,"output",JOptionPane.PLAIN_MESSAGE);
        }
}

}
