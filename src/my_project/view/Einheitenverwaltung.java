package my_project.view;

import javax.swing.*;

public class Einheitenverwaltung {

    private JFrame frame;
    private JPanel mainPanel;

    public Einheitenverwaltung() {
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
