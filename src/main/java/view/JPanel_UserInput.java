package main.java.view;

import main.java.controller.GUIGameController;
import main.java.controller.GameController;

import javax.swing.*;
import javax.swing.text.JTextComponent;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;



public class JPanel_UserInput extends JPanel {
    private static String userInput = "";
    private static JTextField userInputTextField = new JTextField(userInput, 82);


    public JPanel_UserInput() {
        this.setBackground(Color.gray);
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        this.setBorder(BorderFactory.createEmptyBorder(0,0,20,-100));
        this.setBounds(0,570,1250,155);

        userInputTextField.setPreferredSize(new Dimension(1250, 150));
        userInputTextField.setFont(new Font("", Font.PLAIN, 24));
        userInputTextField.setBackground(new Color(5,8,6));
        userInputTextField.setForeground(Color.green);
        userInputTextField.addActionListener(new EnterKeyListener());
        this.add(userInputTextField);
    }

    public static JTextField getUserInputTextField() {
        return userInputTextField;
    }

    private static class EnterKeyListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            userInput = String.valueOf(JPanel_UserInput.getUserInputTextField().getText());
            try {
                GUIGameController.handleEnterKey(userInput);
                userInputTextField.setText("");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }

        }
    }
}
