package main.java.view;

import javax.swing.*;
import java.awt.*;

public class JFrame_Game extends JFrame {

    static  {
        JFrame frame = new JFrame();
        frame.setTitle("72 Hours");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setPreferredSize(new Dimension(500, 500));
        frame.pack();

        JPanel_GameOutput gameOutput = new JPanel_GameOutput();
        JPanel_Inventory inventory = new JPanel_Inventory();
        JPanel_UserInput userInput = new JPanel_UserInput();

        frame.add(gameOutput, BorderLayout.CENTER);
//        frame.add(userInput);
//        frame.add(inventory);
    }



}
