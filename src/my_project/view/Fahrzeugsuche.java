package my_project.view;

import my_project.control.Verwaltungsstart;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Fahrzeugsuche {

    private JFrame frame;
    private JPanel mainPanel;
    private JTextField typTextField;
    private JTextField stationsortIDTextField;
    private JTextField baujahrTextField;
    private JButton sucheNachTypButton;
    private JButton sucheNachFahrzeugenAnButton;
    private JButton sucheFahrzeugeAusDiesemButton;
    private JButton finishButton;
    private Verwaltungsstart vS;


    public Fahrzeugsuche(Verwaltungsstart vS) {
        this.vS = vS;
        frame = new JFrame("Ergebnis der Anfrage");
        frame.setContentPane(mainPanel);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        finishButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });

        sucheFahrzeugeAusDiesemButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vS.ausgabeFahrzeugeBaujahr(baujahrTextField.getText());
            }
        });
        sucheNachFahrzeugenAnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vS.ausgabeFahrzeugeStationsort(stationsortIDTextField.getText());
            }
        });
        sucheNachTypButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vS.ausgabeFahrzeugeTyp(baujahrTextField.getText());
            }
        });
    }
}
