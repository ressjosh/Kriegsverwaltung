package my_project.view;

import my_project.control.CentralControll;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ErstelleNeuePerson {
    private JButton finishAndCreateButton;
    private JTextField maxTextField;
    private JTextField mustermannTextField;
    private JTextField a111111118StelligTextField;
    private JTextField a01012000TextField;
    private JTextField a20TextField;
    private JTextField mTextField;
    private JTextField IDTextField;
    private JTextField musteralleeTextField;
    private JTextField dortmundTextField;
    private JTextField deutschlandTextField;
    private JTextField a111TextField;
    private JTextField a44144TextField;
    private JPanel mainPanel;
    private JFrame frame;
    private CentralControll vS;

    public ErstelleNeuePerson(CentralControll vS) {
        this.vS = vS;
        frame = new JFrame("Ergebnis der Anfrage");
        frame.setContentPane(mainPanel);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        finishAndCreateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vS.erstelleNeuePerson(a111111118StelligTextField.getText(), maxTextField.getText(), mustermannTextField.getText(), a20TextField.getText(), mTextField.getText(), a01012000TextField.getText(), IDTextField.getText(), musteralleeTextField.getText(), a111TextField.getText(), a44144TextField.getText(), dortmundTextField.getText(), deutschlandTextField.getText());
                frame.dispose();
            }
        });
    }
}
