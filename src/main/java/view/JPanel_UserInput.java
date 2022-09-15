package main.java.view;

import javax.swing.*;
import java.awt.*;

public class JPanel_UserInput {
    static {
        JPanel panel3 = new JPanel();
        panel3.setBackground(Color.GREEN);
        panel3.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel3.setBounds(0,250,250,250);
        panel3.add(new JLabel("Player Input"));
    }
}
