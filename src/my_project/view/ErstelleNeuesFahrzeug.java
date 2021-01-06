package my_project.view;

import my_project.control.CentralControll;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ErstelleNeuesFahrzeug {
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JButton finishAndCreateButton;
    private JPanel mainPanel;
    private CentralControll vS;
    private JFrame frame;

    public ErstelleNeuesFahrzeug(CentralControll vS) {
        this.vS = vS;
        frame = new JFrame("Fahrzeugerstellung");
        frame.setContentPane(mainPanel);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        finishAndCreateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vS.erstelleNeuesFahrzeug(textField4.getText(), textField1.getText(), textField5.getText(), textField2.getText(), textField6.getText(), textField3.getText());
                frame.dispose();
            }
        });
    }
}
