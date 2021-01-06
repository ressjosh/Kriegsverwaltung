package my_project.view;

import my_project.control.CentralControll;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Bearbeiten {
    private JTextField primaryKey;
    private JTextField attribut;
    private JTextField neuerWert;
    private JLabel Auflistung;
    private JButton overwriteAndFinishButton;
    private JPanel mainPanel;
    private JFrame frame;
    private int aktuelleTabelle;
    private CentralControll vS;

    public Bearbeiten(CentralControll vS) {
        this.vS = vS;
        aktuelleTabelle = 0;
        frame = new JFrame("Ergebnis der Anfrage");
        frame.setContentPane(mainPanel);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.pack();
        frame.setVisible(false);

        overwriteAndFinishButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(aktuelleTabelle == 1){
                    vS.bearbeiteDatensatz("Erkennungsnummer", primaryKey.getText(), "Personen", attribut.getText(), neuerWert.getText());
                }else if(aktuelleTabelle == 2){
                    vS.bearbeiteDatensatz("ID", primaryKey.getText(), "Fahrzeuge", attribut.getText(), neuerWert.getText());
                }else if(aktuelleTabelle == 3){
                    vS.bearbeiteDatensatz("ID", primaryKey.getText(), "Einheit", attribut.getText(), neuerWert.getText());
                }else if(aktuelleTabelle == 4){
                    vS.bearbeiteDatensatz("Codename", primaryKey.getText(), "Kampfhandlung", attribut.getText(), neuerWert.getText());
                }
                frame.dispose();
            }
        });


    }

    public void setAktuelleTabelle(int aktuelleTabelle){
        this.aktuelleTabelle = aktuelleTabelle;
    }

    public void setVisible(boolean visible){
        frame.setVisible(visible);
    }
}
