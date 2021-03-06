package my_project.view;

import my_project.control.CentralControll;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Aktionsmanager {
    private JButton sucheDatensätzeButton;
    private JButton erstelleEinenNeuenDatensatzButton;
    private JButton showAllButton;
    private JButton deleteThisButton;
    private JTextField zuLöschendenDatensatzHierTextField;
    private JPanel mainPanel;
    private JButton verändereEinenDatensatzButton;
    private JFrame frame;
    private CentralControll vS;
    private int aktuelleTabelle;
    private Bearbeiten b;

    public Aktionsmanager(CentralControll vS) {
        this.vS = vS;
        b = new Bearbeiten(vS);
        frame = new JFrame("Wähle deine Aktion aus");
        frame.setContentPane(mainPanel);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.pack();
        frame.setVisible(false);

        sucheDatensätzeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(aktuelleTabelle == 1){
                    new Personensuche(vS);
                }else if(aktuelleTabelle == 2){
                    new Fahrzeugsuche(vS);
                }else if(aktuelleTabelle == 3){
                    new Einheitensuche(vS);
                }else if(aktuelleTabelle == 4){
                    new Kampfhandlungssuche(vS);
                }
                frame.dispose();
            }
        });

        erstelleEinenNeuenDatensatzButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(aktuelleTabelle == 1){
                    new ErstelleNeuePerson(vS);
                }else if(aktuelleTabelle == 2){
                    new ErstelleNeuesFahrzeug(vS);
                }else if(aktuelleTabelle == 3){
                    new ErstelleNeueEinheit(vS);
                }else if(aktuelleTabelle == 4){
                    new ErstelleNeueKampfhandlung(vS);
                }
                frame.dispose();
            }
        });

        showAllButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(aktuelleTabelle == 1){
                    vS.showAll("Personen");
                }else if(aktuelleTabelle == 2){
                    vS.showAll("Fahrzeuge");
                }else if(aktuelleTabelle == 3){
                    vS.showAll("Einheit");
                }else if(aktuelleTabelle == 4){
                    vS.showAll("Kampfhandlung");
                }
                frame.dispose();
            }
        });

        verändereEinenDatensatzButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(aktuelleTabelle == 1){
                    b.setAktuelleTabelle(1);
                    b.setVisible(true);
                }else if(aktuelleTabelle == 2){
                    b.setAktuelleTabelle(2);
                    b.setVisible(true);
                }else if(aktuelleTabelle == 3){
                    b.setAktuelleTabelle(3);
                    b.setVisible(true);
                }else if(aktuelleTabelle == 4){
                    b.setAktuelleTabelle(4);
                    b.setVisible(true);
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
