package my_project.view;

import my_project.control.Verwaltungsstart;

import javax.swing.*;

public class Gesamtverwaltung {

    private JFrame frame;
    private JPanel mainPanel;

    public Gesamtverwaltung(Verwaltungsstart vS) {
        frame = new JFrame("Ergebnis der Anfrage");
        frame.setContentPane(mainPanel);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.pack();
        frame.setVisible(false);

    }

    public void setVisible(boolean visible){
        frame.setVisible(visible);
    }
}
