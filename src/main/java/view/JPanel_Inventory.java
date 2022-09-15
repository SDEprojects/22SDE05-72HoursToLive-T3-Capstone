package main.java.view;

import javax.swing.*;
import java.awt.*;

public class JPanel_Inventory {
    static {
        JPanel panel2 = new JPanel();
        panel2.setBackground(Color.gray);
        panel2.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel2.setBounds(250,250,250,250);
        panel2.add(new JLabel("Inventory"));
    }
}
