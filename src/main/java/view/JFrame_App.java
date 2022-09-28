package main.java.view;

import javax.swing.*;
import java.awt.*;

public class JFrame_App extends JFrame {
    public JFrame_App() throws HeadlessException {
        this.setTitle("72 Hours");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setVisible(true);
        this.setPreferredSize(new Dimension(1250, 1000));
        this.pack();
        this.setLocationRelativeTo(null);

    }
}
