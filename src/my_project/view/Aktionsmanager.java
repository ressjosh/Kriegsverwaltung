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
    private JFrame frame;
    private CentralControll vS;
    private int aktuelleTabelle;

    public Aktionsmanager(CentralControll vS) {
        this.vS = vS;
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
                    vS.showAllPersonen();
                }else if(aktuelleTabelle == 2){
                    vS.showAllFahrzeuge();
                }else if(aktuelleTabelle == 3){
                    vS.showAllEinheiten();
                }else if(aktuelleTabelle == 4){
                    vS.showAllKampfhandlungen();
                }
                frame.dispose();
            }
        });

        deleteThisButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(aktuelleTabelle == 1){
                    vS.deletePerson(zuLöschendenDatensatzHierTextField.getText());
                }else if(aktuelleTabelle == 2){
                    vS.deleteFahrzeug(zuLöschendenDatensatzHierTextField.getText());
                }else if(aktuelleTabelle == 3){
                    vS.deleteEinheit(zuLöschendenDatensatzHierTextField.getText());
                }else if(aktuelleTabelle == 4){
                    vS.deleteKampfhandlung(zuLöschendenDatensatzHierTextField.getText());
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
