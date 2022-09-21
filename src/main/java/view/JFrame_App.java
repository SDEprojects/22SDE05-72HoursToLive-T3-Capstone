package main.java.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JFrame_App extends JFrame {
//    private static final JPanel_GameOutput gameOutputPanel = new JPanel_GameOutput();
//    private final JPanel_UserInput userInputPanel = new JPanel_UserInput();
//    private final JPanel_InformationBar informationBar = new JPanel_InformationBar();
//    private final JPanel_Map mapPanel = new JPanel_Map();

    public JFrame_App() throws HeadlessException {
        this.setTitle("72 Hours");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setVisible(true);
        this.setPreferredSize(new Dimension(1050, 645));
        this.pack();
        this.setLocationRelativeTo(null);

//        this.add(gameOutputPanel, BorderLayout.CENTER);
//        this.add(userInputPanel, BorderLayout.CENTER);
//        this.add(mapPanel, BorderLayout.CENTER);
//        this.add(informationBar, BorderLayout.CENTER);
    }

//    public JPanel_GameOutput getGameOutputPanel() {
//        return gameOutputPanel;
//    }
//
//    public JPanel_UserInput getUserInputPanel() {
//        return userInputPanel;
//    }
//
//    public JPanel_InformationBar getInformationBar() {
//        return informationBar;
//    }
//
//    public JPanel_Map getMapPanel() {
//        return mapPanel;
//    }

}
