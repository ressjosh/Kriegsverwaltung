package my_project.view;

import my_project.control.CentralControll;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Einheitensuche {

    private CentralControll vS;
    private JFrame frame;
    private JPanel mainPanel;
    private JTextField mindestErfahrungswertTextField;
    private JTextField mindestKampfkraftTextField;
    private JTextField bestimmteIDTextField;
    private JButton searchButton;
    private JButton searchButton1;
    private JButton searchButton2;
    private JButton finishButton;

    public Einheitensuche(CentralControll vS) {
        frame = new JFrame("Ergebnis der Anfrage");
        frame.setContentPane(mainPanel);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        searchButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vS.ausgabeEinheitID();
            }
        });

        searchButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vS.ausgabeEinheitMindestKampfkraft();
            }
        });

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vS.ausgabeEinheitMindestErfahrung();
            }
        });
        finishButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
    }
}
