package my_project.view;

import my_project.control.CentralControll;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Kampfhandlungssuche {
    private JPanel mainPAnel;
    private JTextField attributwert01;
    private JTextField attributwert02;
    private JButton searchAndFinishButton;
    private JLabel Attribut01;
    private JLabel Attribut02;
    private JButton searchButton;
    private JButton searchButton1;
    private CentralControll vS;
    private JFrame frame;

    public Kampfhandlungssuche(CentralControll vS) {
        this.vS = vS;
        frame = new JFrame("Ergebnis der Anfrage");
        frame.setContentPane(mainPAnel);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        searchAndFinishButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int tmp = countSuchparameter();
                String[] attribute = suchParameterAusgeben(tmp);

                if(tmp == 1){
                    vS.ausgabeKampfhandlungEinParameter(attribute[0], attribute[1]);
                }else if(tmp == 2) {
                    vS.ausgabeKampfhandlungZweiParameter(attribute[0], attribute[1], attribute[2], attribute[3]);
                }

                frame.dispose();
            }
        });
    }

    private int countSuchparameter(){
        int result = 0;
        if(!attributwert01.getText().equals("") && !attributwert01.getText().equals("Standort ID")){
            result++;
        }
        if(!attributwert02.getText().equals("") && !attributwert02.getText().equals("Feind ID")){
            result++;
        }

        System.out.println("Anzahl Suchattribute: " + result);
        return result;
    }

    private String[] suchParameterAusgeben(int anzahlParameter){
        String zwischenResultat = "";
        if(!attributwert01.getText().equals("") && !attributwert01.getText().equals("Standort ID")){
            zwischenResultat = zwischenResultat + Attribut01.getText() + "§" + attributwert01.getText();
        }
        if(!attributwert02.getText().equals("") && !attributwert02.getText().equals("Feind ID")){
            zwischenResultat = zwischenResultat + "§" + Attribut02.getText() + "§" + attributwert02.getText();
        }

        String[] result = zwischenResultat.split("§");
        System.out.println(zwischenResultat);
        return result;
    }
}
