package main.java.view;

import javax.swing.*;
import java.awt.*;

public class JPanel_UserInput extends JPanel {
    public JPanel_UserInput() {
        this.setBackground(Color.gray);


        JTextArea userInputTextArea = new JTextArea("go west", 9, 82);
        userInputTextArea.setBackground(new Color(5,8,6));
        userInputTextArea.setForeground(Color.green);
        userInputTextArea.setLineWrap(true);
        userInputTextArea.setWrapStyleWord(true);
        userInputTextArea.setToolTipText("Users can enter their response here");
        JScrollPane scrollPane = new JScrollPane(userInputTextArea);
        this.add(userInputTextArea);
    }
}
