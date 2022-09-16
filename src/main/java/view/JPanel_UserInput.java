package main.java.view;

import javax.swing.*;
import java.awt.*;

public class JPanel_UserInput extends JPanel {
    public JPanel_UserInput() {
        this.setLayout(new GridLayout(2, 0,0,0));

        this.setBackground(Color.white);
        JLabel userInput = new JLabel("User Input");
        userInput.setHorizontalAlignment(JLabel.CENTER);
        userInput.setForeground(Color.black);
        this.add(userInput);

        JTextArea userInputTextArea = new JTextArea("", 9, 82);
        userInputTextArea.setBackground(Color.black);
        userInputTextArea.setForeground(Color.white);

        userInputTextArea.setLineWrap(true);
        userInputTextArea.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(userInputTextArea);
        this.add(userInputTextArea);
    }
}
