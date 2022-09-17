package main.java.view;

import javax.swing.*;
import java.awt.*;

public class JPanel_UserInput extends JPanel {
    private String userInput = "";
    private JTextField userInputTextField = new JTextField(userInput, 82);

    public JPanel_UserInput() {
        this.setBackground(Color.gray);
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        this.setBounds(0,570,1250,155);

        userInputTextField.setPreferredSize(new Dimension(1250, 150));
        userInputTextField.setFont(new Font("", Font.PLAIN, 16));
        userInputTextField.setBackground(new Color(5,8,6));
        userInputTextField.setForeground(Color.green);
        userInputTextField.setToolTipText("Users can enter their response here");
        this.add(userInputTextField);
    }

    public String getUserInput() {
        return userInput;
    }

    public void setUserInput(String userInput) {
        this.userInput = userInput;
    }

    public JTextField getUserInputTextField() {
        return userInputTextField;
    }

    public void setUserInputTextField(JTextField userInputTextField) {
        this.userInputTextField = userInputTextField;
    }
}
