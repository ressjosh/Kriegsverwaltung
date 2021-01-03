package my_project.view;

import my_project.control.Verwaltungsstart;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class Kampfverwaltung {
    private JFrame frame;
    private JPanel mainPanel;
    private JButton zeigeAlleAktuellenKampfhandlungenButton;
    private JButton erstelleEineNeueKampfhandlungButton;
    private JButton sucheBestimmteKampfhandlungButton;
    private Verwaltungsstart vS;

    public Kampfverwaltung(Verwaltungsstart vS) {
        this.vS = vS;
        frame = new JFrame("Ergebnis der Anfrage");
        frame.setContentPane(mainPanel);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.pack();
        frame.setVisible(false);

        sucheBestimmteKampfhandlungButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Kampfhandlungssuche(vS);
                frame.dispose();
            }
        });

        zeigeAlleAktuellenKampfhandlungenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vS.giveAllKampfhandlungen();
                frame.dispose();
            }
        });

        erstelleEineNeueKampfhandlungButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ErstelleNeueKampfhandlung(vS);
                frame.dispose();
            }
        });
    }

    public void setVisible(boolean visible){
        frame.setVisible(visible);
    }
}
