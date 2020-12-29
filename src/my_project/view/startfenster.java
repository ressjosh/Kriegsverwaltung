package my_project.view;

import KAGO_framework.control.ViewController;
import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;

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
        setNewImage("daten/startbutton.jpg");
        startButton = new Button(100, 100, getMyImage(), 0, this);
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
