package my_project.view;

import my_project.control.CentralControll;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gesamtverwaltung {

    private JFrame frame;
    private JPanel mainPanel;
    private JButton fahrzeugtypenButton;
    private JButton besatzungButton;
    private JButton feindeButton;
    private CentralControll vS;

    public Gesamtverwaltung(CentralControll vS) {
        this.vS = vS;
        frame = new JFrame("Ergebnis der Anfrage");
        frame.setContentPane(mainPanel);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.pack();
        frame.setVisible(false);

        feindeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vS.showAllFeinde();
                frame.dispose();
            }
        });

        besatzungButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vS.showAllBesatzungen();
                frame.dispose();
            }
        });

        fahrzeugtypenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vS.showAllFahrzeugtypen();
                frame.dispose();
            }
        });
    }

    public void setVisible(boolean visible){
        frame.setVisible(visible);
    }
}
