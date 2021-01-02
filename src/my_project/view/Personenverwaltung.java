package my_project.view;

import my_project.control.Verwaltungsstart;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Personenverwaltung {

    private JFrame frame;
    private JPanel mainPanel;
    private JButton erstelleEineNeuePersonButton;
    private JButton suchePersonenButton;
    private Verwaltungsstart vS;

    public Personenverwaltung(Verwaltungsstart vS) {
        this.vS = vS;
        frame = new JFrame("Ergebnis der Anfrage");
        frame.setContentPane(mainPanel);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.pack();
        frame.setVisible(false);

        suchePersonenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Personensuche(vS);
                frame.dispose();
            }
        });
        erstelleEineNeuePersonButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ErstelleNeuePerson(vS);
                frame.dispose();
            }
        });
    }

    public void setVisible(boolean visible){
        frame.setVisible(visible);
    }
}
