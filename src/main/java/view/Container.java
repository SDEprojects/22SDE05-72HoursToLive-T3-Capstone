package main.java.view;

import javax.swing.*;
import java.awt.*;

public class Container {
    private static final JFrame frame = new JFrame();

    public static void main(String[] args) {
        JPanel panel = new JPanel();
        panel.setBackground(Color.CYAN);
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.setBounds(0,0,500,250);
        panel.add(new JLabel("Game Output"));

        JPanel panel2 = new JPanel();
        panel2.setBackground(Color.gray);
        panel2.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel2.setBounds(250,250,250,250);
        panel2.add(new JLabel("Inventory"));

        JPanel panel3 = new JPanel();
        panel3.setBackground(Color.GREEN);
        panel3.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel3.setBounds(0,250,250,250);
        panel3.add(new JLabel("Player Input"));

        frame.setTitle("72 Hours");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setPreferredSize(new Dimension(500, 500));
        frame.pack();
        frame.add(panel, BorderLayout.CENTER);
        frame.add(panel2, BorderLayout.CENTER);
        frame.add(panel3, BorderLayout.CENTER);
    }
}
