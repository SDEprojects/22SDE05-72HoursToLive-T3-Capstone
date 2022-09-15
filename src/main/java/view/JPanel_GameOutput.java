package main.java.view;

import javax.swing.*;
import java.awt.*;

public class JPanel_GameOutput extends JPanel{
    public JPanel_GameOutput() {
        this.setBackground(Color.cyan);
        this.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        this.setBounds(0,0,1000,500);
        this.add(new JLabel("Game Output"));

        JTextArea textArea = new JTextArea("");
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(textArea);
        this.add(textArea);
    }
}
