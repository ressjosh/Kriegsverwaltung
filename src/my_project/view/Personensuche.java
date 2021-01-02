package my_project.view;

import my_project.control.Verwaltungsstart;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class Personensuche {
    private JTextField eineEinheitsIDEingebenTextField;
    private JTextField oderHierEinAlterTextField;
    private JTextField oderHierEinenNachnamenTextField;
    private JTextField oderHierEineErkennungsnummerTextField;
    private JButton ausEinerEinheitButton;
    private JButton diesesAltersButton;
    private JButton nachNachnameButton;
    private JButton dieseErkennungsnummerButton;
    private JPanel mainPanel;
    private JButton endSearchButton;
    private Verwaltungsstart vS;
    private JFrame frame;


    public Personensuche(Verwaltungsstart vS) {
        frame = new JFrame("'Suche nach bestimmten Personen'");
        frame.setContentPane(mainPanel);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        this.vS = vS;

        ausEinerEinheitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vS.ausgabePersonenEinheit(eineEinheitsIDEingebenTextField.getText());
            }
        });

        nachNachnameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vS.ausgabePersonenNachname(oderHierEinenNachnamenTextField.getText());
            }
        });

        dieseErkennungsnummerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vS.ausgabePersonenErkennungsnummer(oderHierEineErkennungsnummerTextField.getText());
            }
        });

        diesesAltersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vS.ausgabePersonenAlter(oderHierEinAlterTextField.getText());
            }
        });

        endSearchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
    }
}
