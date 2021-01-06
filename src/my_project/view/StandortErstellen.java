package my_project.view;

import my_project.control.ViewControll;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StandortErstellen {
    private JTextField IDTextField;
    private JTextField yKoordinate0600TextField;
    private JTextField xKoordinate0900TextField;
    private JTextField nameTextField;
    private JTextField inGanzenZahlenTextField;
    private JPanel mainPanel;
    private JButton erstelleDenStandortButton;
    private JFrame frame;
    private ViewControll vC;

    public StandortErstellen(ViewControll vC){
        frame = new JFrame("Ergebnis der Anfrage");
        frame.setContentPane(mainPanel);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        this.vC = vC;

        erstelleDenStandortButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                vC.newStandort(nameTextField.getText(), Integer.parseInt(xKoordinate0900TextField.getText()), Integer.parseInt(yKoordinate0600TextField.getText()), IDTextField.getText(), Integer.parseInt(inGanzenZahlenTextField.getText()) );
            }
        });
    }
}
