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
    private static JTextField userInputTextField = new JTextField(38);

    public JPanel_UserInput() {
//        this.setBackground(Color.gray);
        this.setBorder(BorderFactory.createLineBorder(Color.black));
//        this.setBounds(510,325,500,225);
        this.setBorder(BorderFactory.createEmptyBorder(0,0,20,-100));
        this.setBounds(500,325,500,225);


        userInputTextField.setFont(new Font("", Font.PLAIN, 16));
        userInputTextField.setBackground(new Color(5,8,6));
        userInputTextField.setForeground(Color.green);
        userInputTextField.addActionListener(new EnterKeyListener());
        this.add(userInputTextField);
    }

    public static String getUserInput() {
        return userInput;
    }

    public void setUserInput(String userInput) {
        JPanel_UserInput.userInput = userInput;
    }

    public static JTextField getUserInputTextField() {
        return userInputTextField;
    }

    public void setUserInputTextField(JTextField userInputTextField) {
        JPanel_UserInput.userInputTextField = userInputTextField;
    }

    public void addSubmitTextListener(ActionListener listenForEnter) {
        userInputTextField.addActionListener(listenForEnter);
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
