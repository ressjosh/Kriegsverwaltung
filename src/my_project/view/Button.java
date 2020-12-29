package my_project.view;

import KAGO_framework.model.GraphicalObject;
import KAGO_framework.model.InteractiveGraphicalObject;
import KAGO_framework.view.DrawTool;

import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class Button extends InteractiveGraphicalObject {

    private BufferedImage myImage;
    private double x;
    private double y;
    private int breite;
    private int hoehe;
    private String text;
    private int buttonNummer;
    private ButtonUser myUser;

    public Button(String text, int groesse, double x, double y, String farbe, int buttonNr, ButtonUser user){
        myUser = user;
        buttonNummer = buttonNr;
        this.x = x;
        this.y = y;
        this.text = text;
        this.hoehe = groesse;
        this.breite = text.length()*(groesse-2)*3/5+15;
    }

    public Button(double x, double y, BufferedImage buttonBild, int buttonNr, ButtonUser user){

    }


    @Override
    public void keyPressed(int key) {

    }

    @Override
    public void keyReleased(int key) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }
}
