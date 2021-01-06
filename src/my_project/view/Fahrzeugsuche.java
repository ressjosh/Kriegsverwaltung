package my_project.view;

import my_project.control.CentralControll;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Fahrzeugsuche {

    private JFrame frame;
    private JPanel mainPanel;
    private JTextField attributwert01;
    private JTextField attributwert02;
    private JTextField attributwert03;
    private JButton finishButton;
    private JLabel Attribut03;
    private JLabel Attribut02;
    private JLabel Attribut01;
    private CentralControll vS;


    public Fahrzeugsuche(CentralControll vS) {
        this.vS = vS;
        frame = new JFrame("Ergebnis der Anfrage");
        frame.setContentPane(mainPanel);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        finishButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int tmp = countSuchparameter();
                String[] attribute = suchParameterAusgeben(tmp);

                if(tmp == 1){
                    vS.ausgabeFahrzeugeEinParameter( attribute[1], attribute[2]);
                }else if(tmp == 2){
                    vS.ausgabeFahrzeugeZweiParameter( attribute[1], attribute[2], attribute[3], attribute[4]);
                }else if(tmp == 3){
                    vS.ausgabeFahrzeugeDreiParameter( attribute[1], attribute[2], attribute[3], attribute[4], attribute[5], attribute[6]);
                }
                frame.dispose();
            }
        });


    }

    private int countSuchparameter(){
        int result = 0;
        if(!attributwert01.getText().equals("") && !attributwert01.getText().equals("Typ ID des Fahrzeuges")){
            result++;
        }
        if(!attributwert02.getText().equals("") && !attributwert02.getText().equals("Stationsort (ID)")){
            result++;
        }
        if(!attributwert03.getText().equals("") && !attributwert03.getText().equals("Baujahr")){
            result++;
        }

        System.out.println("Anzahl Suchattribute: " + result);
        return result;
    }

    private String[] suchParameterAusgeben(int anzahlParameter){
        String zwischenResultat = "";
        if(!attributwert01.getText().equals("") && !attributwert01.getText().equals("Typ ID des Fahrzeuges")){
            zwischenResultat = zwischenResultat +"§" +  "JR_Kv_Fahrzeuge." + Attribut01.getText() + "§" + attributwert01.getText();
        }
        if(!attributwert02.getText().equals("") && !attributwert02.getText().equals("Stationsort (ID)")){
            zwischenResultat = zwischenResultat + "§" +  "JR_Kv_Fahrzeuge." +Attribut02.getText() + "§" + attributwert02.getText();
        }
        if(!attributwert03.getText().equals("") && !attributwert03.getText().equals("Baujahr")){
            zwischenResultat = zwischenResultat + "§" +  "JR_Kv_Fahrzeuge." +Attribut03.getText() + "§" + attributwert03.getText();
        }

        String[] result = zwischenResultat.split("§");
        System.out.println(zwischenResultat);
        return result;

    }
}
