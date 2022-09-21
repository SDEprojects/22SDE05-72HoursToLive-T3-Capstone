//package main.java.view;
//
//import main.java.controller.GUIGameController;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//public class JPanel_ButtonsPanel extends JPanel {
//
//
//    public JPanel_ButtonsPanel() {
//        this.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 5));
//        this.setBackground(Color.red);
//        this.setBorder(BorderFactory.createLineBorder(Color.black));
//
//        JButton startBtn = new JButton("START");
//        startBtn.setBounds(120, 400, 100, 50);
//        startBtn.setBackground(Color.black);
//        startBtn.setForeground(Color.green);
//        startBtn.setVisible(true);
//
//        JButton helpBtn = new JButton("HELP");
//        helpBtn.setBounds(340, 400, 100, 50);
//        helpBtn.setBackground(Color.black);
//        helpBtn.setForeground(Color.green);
//        helpBtn.addActionListener(new GUIGameController.handleHelpBtnClick());
//
//        JButton musicBtn = new JButton("MUSIC");
//        musicBtn.setBounds(560, 400, 100, 50);
//        musicBtn.setBackground(Color.black);
//        musicBtn.setForeground(Color.green);
//
//        JButton quitBtn = new JButton("QUIT");
//        quitBtn.setBounds(780, 400, 100, 50);
//        quitBtn.setBackground(Color.black);
//        quitBtn.setForeground(Color.green);
////        quitBtn.addActionListener(new handleQuitBtnClick());
//
//    }
//
//    private class handleHelpBtnClick implements ActionListener {
//
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            displayHelpPage();
//        }
//    }
//}
