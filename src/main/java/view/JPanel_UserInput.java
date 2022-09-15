package main.java.view;

import javax.swing.*;
import java.awt.*;

public class JPanel_UserInput extends JPanel {
    public JPanel_UserInput() {
        this.setBackground(Color.LIGHT_GRAY);
        this.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        this.setBounds(0,500,500,500);
        this.add(new JLabel("Player Input"));

        JTextArea textArea = new JTextArea("");
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(textArea);
        this.add(textArea);
    }
}
