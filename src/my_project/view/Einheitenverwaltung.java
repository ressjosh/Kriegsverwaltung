package my_project.view;

import my_project.control.Verwaltungsstart;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Einheitenverwaltung {

    private JFrame frame;
    private JPanel mainPanel;
    private JButton sucheEinheitenButton;
    private JButton erstelleNeueEinheitButton;
    private JButton showAllEinheitenButton;
    private Verwaltungsstart vS;

    public Einheitenverwaltung(Verwaltungsstart vS) {
        this.vS = vS;
        frame = new JFrame("Ergebnis der Anfrage");
        frame.setContentPane(mainPanel);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.pack();
        frame.setVisible(false);

        showAllEinheitenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vS.showAllEinheiten();
                frame.dispose();
            }
        });
        sucheEinheitenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Einheitensuche(vS);
                frame.dispose();
            }
        });
        erstelleNeueEinheitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ErstelleNeueEinheit(vS);
                frame.dispose();
            }
        });
    }

    public void setVisible(boolean visible){
        frame.setVisible(visible);
    }
}
