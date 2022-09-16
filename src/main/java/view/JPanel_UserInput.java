package main.java.view;

import javax.swing.*;
import java.awt.*;

public class JPanel_UserInput extends JPanel {
    public JPanel_UserInput() {
        this.setBackground(Color.gray);
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        this.setBounds(0,570,1250,155);


        JTextArea userInputTextArea = new JTextArea("go west", 9, 103);
        userInputTextArea.setBackground(new Color(5,8,6));
        userInputTextArea.setForeground(Color.green);
        userInputTextArea.setLineWrap(true);
        userInputTextArea.setWrapStyleWord(true);
        userInputTextArea.setToolTipText("Users can enter their response here");
        JScrollPane scrollPane = new JScrollPane(userInputTextArea);
        this.add(userInputTextArea);
    }
}
