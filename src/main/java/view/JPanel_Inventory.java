package main.java.view;

import javax.swing.*;
import java.awt.*;

public class JPanel_Inventory extends JPanel{
    public JPanel_Inventory() {
        this.setBackground(Color.GRAY);
        this.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        this.setBounds(500,500,500,500);
        this.add(new JLabel("Inventory"));

        JTextArea textArea = new JTextArea("");
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(textArea);
        this.add(textArea);
    }
}
