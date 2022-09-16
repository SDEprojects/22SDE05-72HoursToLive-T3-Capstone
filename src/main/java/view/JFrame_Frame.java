package main.java.view;

import javax.swing.*;
import java.awt.*;

public class JFrame_Frame extends JFrame {
    private final JPanel_GameOutput gameOutputPanel = new JPanel_GameOutput();
    private final JPanel_InformationBar inventoryPanel = new JPanel_InformationBar();
    private final JPanel_Map map = new JPanel_Map();

    public JFrame_Frame() throws HeadlessException {
        this.setTitle("72 Hours");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setVisible(true);
        this.setPreferredSize(new Dimension(1000, 825));
        this.pack();
        this.add(gameOutputPanel, BorderLayout.CENTER);
        this.add(map, BorderLayout.CENTER);
        this.add(inventoryPanel, BorderLayout.CENTER);
    }
}
