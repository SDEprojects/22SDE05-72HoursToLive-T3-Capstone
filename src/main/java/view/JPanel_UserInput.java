package main.java.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JPanel_UserInput extends JPanel {
    private static String userInput = "";
    private static JTextField userInputTextField = new JTextField(userInput, 82);

    public JPanel_UserInput() {
        this.setBackground(Color.gray);
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        this.setBounds(0,570,1000,400);

        userInputTextField.setPreferredSize(new Dimension(500, 500));
        userInputTextField.setFont(new Font("", Font.PLAIN, 16));
        userInputTextField.setBackground(new Color(5,8,6));
        userInputTextField.setForeground(Color.green);
        userInputTextField.setToolTipText("Users can enter their response here");
        //this.addSubmitTextListener(new EnterKeyListener());
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

//    private static class EnterKeyListener implements ActionListener {
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            userInput = String.valueOf(JPanel_UserInput.getUserInputTextField());
//            JPanel_GameOutput.appendGameTextArea(userInput);
//        }
//    }
}
