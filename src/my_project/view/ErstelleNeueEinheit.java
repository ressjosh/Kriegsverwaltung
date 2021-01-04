package my_project.view;

import my_project.control.CentralControll;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ErstelleNeueEinheit {
    private JPanel mainPanel;
    private JButton createAndFinishButton;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private CentralControll vS;
    private JFrame frame;

    public ErstelleNeueEinheit(CentralControll vS) {
        frame = new JFrame("Ergebnis der Anfrage");
        frame.setContentPane(mainPanel);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        this.vS = vS;

        createAndFinishButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vS.erstelleNeueEinheit();
                frame.dispose();
            }
        });
    }
}
