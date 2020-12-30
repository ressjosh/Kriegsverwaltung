package my_project.view;

import KAGO_framework.control.ViewController;
import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class startfenster extends GraphicalObject implements ButtonUser{

    private BufferedImage startbild;
    private Button startButton;
    private Button selectMusic;
    private ViewController viewController;
    private Hintergrundbild hintergrund;

    public startfenster(ViewController vC){
        viewController = vC;
        setNewImage("daten/startbild.jpg");
        hintergrund = new Hintergrundbild(getMyImage());
        setNewImage("daten/startbutton02.png");
        startButton = new Button(100, 100, getMyImage(), 0, this);
        setNewImage("daten/chooseMusic.png");
        selectMusic = new Button(600,100, getMyImage(), 1, this);
        registriereButtons(vC);

    }

    @Override
    public void draw(DrawTool drawTool) {

    }

    @Override
    public void update(double dt) {
        super.update(dt);
    }

    public void buttoneffect(int buttonNummer){
        if(buttonNummer == 0){
            viewController.showScene(1);
        }
        if(buttonNummer == 1){
                String[] options = new String[3];
                options[0] = "Keine Hintergrundmusik";
                options[1] = "01";
                options[2] = "02";
                int eingabe = JOptionPane.showOptionDialog(
                        null, //Component
                        "Wähle eine Hintergrundmusik",
                        "Musikauswahl",
                        JOptionPane.YES_NO_CANCEL_OPTION,
                        JOptionPane.PLAIN_MESSAGE,
                        null, //Icon
                        options,
                        options[0] );
                if(eingabe == 0){
                    System.out.println("Du hast keine Musik gewählt");
                }else if(eingabe == 1){
                    System.out.println("Du hast Musik 01 gewählt");
                }else if(eingabe == 2){
                    System.out.println("Du hast Musik 02 gewählt");
                }
        }
    }

    @Override
    public void registriereButtons(ViewController vC) {
        vC.draw(hintergrund, 0);
        vC.draw(startButton,0);
        vC.register(startButton,0);
        vC.draw(selectMusic, 0);
        vC.register(selectMusic, 0);
    }
}
