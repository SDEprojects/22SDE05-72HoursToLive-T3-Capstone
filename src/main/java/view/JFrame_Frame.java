package main.java.view;

import javax.swing.*;
import java.awt.*;

public class JFrame_Frame extends JFrame {
    private final JPanel_GameOutput gameOutputPanel = new JPanel_GameOutput();
    private final JPanel_InformationBar informationBar = new JPanel_InformationBar();
    private final JPanel_Map mapPanel = new JPanel_Map();

    public JFrame_Frame() throws HeadlessException {
        this.setTitle("72 Hours");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setVisible(true);
        this.setPreferredSize(new Dimension(1000, 825));
        this.pack();
        this.setLocationRelativeTo(null);

        this.add(gameOutputPanel, BorderLayout.CENTER);
        this.add(mapPanel, BorderLayout.CENTER);
        this.add(informationBar, BorderLayout.CENTER);
    }
}
