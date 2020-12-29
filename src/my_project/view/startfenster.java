package my_project.view;

import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;

import java.awt.*;
import java.awt.image.BufferedImage;

public class startfenster extends GraphicalObject implements ButtonUser{

    private BufferedImage startbild;

    public startfenster(){
        setNewImage("daten/startbild.jpg");
        startbild = getMyImage();
    }

    @Override
    public void draw(DrawTool drawTool) {
        drawTool.drawImage(startbild, 0, 0);
    }

    @Override
    public void update(double dt) {
        super.update(dt);
    }

    public void buttoneffect(){

    }
}
