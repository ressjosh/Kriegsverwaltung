package my_project.view;

import my_project.control.CentralControll;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ErstelleNeueKampfhandlung {
    private JPanel mainPanel;
    private JButton createAnFinishButton;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private CentralControll vS;
    private JFrame frame;

    public ErstelleNeueKampfhandlung(CentralControll vS) {
        this.vS = vS;
        frame = new JFrame("Kampferstellung");
        frame.setContentPane(mainPanel);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        createAnFinishButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] tmp = splitteEinheitenAuf();
                vS.erstelleNeueKampfhandlung(textField1.getText(), textField2.getText(), textField3.getText(), textField4.getText(), textField5.getText(), tmp);
                frame.dispose();
            }
        });
    }

    public String[] splitteEinheitenAuf(){
        String[] tmp = textField6.getText().split(";");
        return tmp;
    }
}
