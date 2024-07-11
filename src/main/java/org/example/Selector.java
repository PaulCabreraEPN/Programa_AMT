package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Selector {
    public JPanel MainPanel;
    private JButton registrarUnVehículoButton;
    private JButton buscarUnVehículoButton;

    public Selector() {
        registrarUnVehículoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame();
                frame.setContentPane(new Register().MainPanel);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(400,650);
                frame.setVisible(true);

                ((JFrame)SwingUtilities.getWindowAncestor(registrarUnVehículoButton)).dispose();

            }
        });
        buscarUnVehículoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame();
                frame.setContentPane(new Search().MainPanel);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(400,650);
                frame.setVisible(true);

                ((JFrame)SwingUtilities.getWindowAncestor(registrarUnVehículoButton)).dispose();
            }
        });
    }
}
