package my_project.view;

import my_project.control.CentralControll;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Personensuche {
    private JTextField attributwert01;
    private JTextField attributwert02;
    private JTextField attributwert03;
    private JTextField attributwert04;
    private JPanel mainPanel;
    private JButton endSearchButton;
    private JLabel Attribut01;
    private JLabel Attribut02;
    private JLabel Attribut03;
    private JLabel Attribut04;
    private CentralControll vS;
    private JFrame frame;


    public Personensuche(CentralControll vS) {
        frame = new JFrame("'Suche nach bestimmten Personen'");
        frame.setContentPane(mainPanel);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        this.vS = vS;

        endSearchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int tmp = countSuchparameter();
                String[] attribute = suchParameterAusgeben(tmp);

                if(tmp == 1){
                    vS.ausgabePersonenEinParameter( attribute[1], attribute[2]);
                }else if(tmp == 2){
                    vS.ausgabePersonenZweiParameter(attribute[1], attribute[2], attribute[3], attribute[4]);
                }else if(tmp == 3){
                    vS.ausgabePersonenDreiParameter(attribute[1], attribute[2], attribute[3], attribute[4], attribute[5], attribute[6]);
                }else if(tmp == 4){
                    vS.ausgabePersonenVierParameter(attribute[1], attribute[2], attribute[3], attribute[4], attribute[5], attribute[6], attribute[7], attribute[8]);
                }
                frame.dispose();
            }
        });
    }

    private int countSuchparameter(){
        int result = 0;
        if(!attributwert01.getText().equals("") && !attributwert01.getText().equals("EinheitsID")){
            result++;
        }
        if(!attributwert02.getText().equals("") && !attributwert02.getText().equals("Alter in ganzen Zahlen")){
            result++;
        }
        if(!attributwert03.getText().equals("") && !attributwert03.getText().equals("Mustermann")){
            result++;
        }if(!attributwert04.getText().equals("") && !attributwert04.getText().equals("Erkennungsnummer")){
            result++;
        }

        System.out.println("Anzahl Suchattribute: " + result);
        return result;
    }

    private String[] suchParameterAusgeben(int anzahlParameter){
        String zwischenResultat = "";
        if(!attributwert01.getText().equals("") && !attributwert01.getText().equals("EinheitsID")){
            zwischenResultat = zwischenResultat + "§" +Attribut01.getText() + "§" + attributwert01.getText();
        }
        if(!attributwert02.getText().equals("") && !attributwert02.getText().equals("Alter in ganzen Zahlen")){
            zwischenResultat = zwischenResultat + "§" + Attribut02.getText() + "§" + attributwert02.getText();
        }
        if(!attributwert03.getText().equals("") && !attributwert03.getText().equals("Mustermann")){
            zwischenResultat = zwischenResultat + "§" + Attribut03.getText() + "§" + attributwert03.getText();
        }if(!attributwert04.getText().equals("") && !attributwert04.getText().equals("Erkennungsnummer")){
            zwischenResultat = zwischenResultat + "§" + Attribut04.getText() + "§" + attributwert04.getText();
        }

        String[] result = zwischenResultat.split("§");
        System.out.println(zwischenResultat);
        return result;
    }
}
