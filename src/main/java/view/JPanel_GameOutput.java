package main.java.view;

import javax.swing.*;
import java.awt.*;

public class JPanel_GameOutput {
    public JPanel_GameOutput() {
        JPanel panel = new JPanel();
        panel.setBackground(Color.CYAN);
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.setBounds(0,0,500,250);
        panel.add(new JLabel("Game Output"));

//        String text = "The quick brown fox ";
//
//        JTextArea textArea = new JTextArea(text);
//        textArea.setLineWrap(true);
//        textArea.setWrapStyleWord(true);
//        JScrollPane scrollPane = new JScrollPane(textArea);
//        panel.add(textArea);
    }
}
