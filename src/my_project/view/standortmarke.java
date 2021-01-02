package my_project.view;

import KAGO_framework.model.InteractiveGraphicalObject;
import KAGO_framework.view.DrawTool;
import my_project.control.ViewControll;

import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class standortmarke extends InteractiveGraphicalObject {

    private int y;
    private int x;
    private BufferedImage standortMarke;
    private ViewControll vC;


    public standortmarke(int y, int x, ViewControll vC) {
        this.vC = vC;
        this.y = y;
        this.x = x;
        setNewImage("daten/standortMarke.png");
        standortMarke = getMyImage();
    }

    public void draw(DrawTool drawTool){
        drawTool.drawImage(standortMarke, x-standortMarke.getWidth()/2, y-standortMarke.getHeight());
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
        double mouseX = e.getX();
        double mouseY = e.getY();
        if(mouseX > x-standortMarke.getWidth()/2 && mouseX < x+standortMarke.getWidth()/2 && mouseY > y-standortMarke.getHeight() && mouseY < y){
            vC.getvS().gibStandortDatenAus(x, y);
            //new standortfenster();
        }
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

    public int getMyY() {
        return y;
    }

    public int getMyX() {
        return x;
    }
}
