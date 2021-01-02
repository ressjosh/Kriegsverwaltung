package my_project.view;

import my_project.control.Verwaltungsstart;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Fahrzeugverwaltung {

    private JFrame frame;
    private JPanel mainPanel;
    private JButton erstelleEinNeuesFahrzeugButton;
    private JButton sucheNachFahrzeugenButton;
    private Verwaltungsstart vS;

    public Fahrzeugverwaltung( Verwaltungsstart vS) {
        this.vS = vS;
        frame = new JFrame("Ergebnis der Anfrage");
        frame.setContentPane(mainPanel);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.pack();
        frame.setVisible(false);

        sucheNachFahrzeugenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ErstelleNeuesFahrzeug(vS);
                frame.dispose();
            }
        });
        erstelleEinNeuesFahrzeugButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Fahrzeugsuche(vS);
                frame.dispose();
            }
        });
    }

    public void setVisible(boolean visible){
        frame.setVisible(visible);
    }
}
