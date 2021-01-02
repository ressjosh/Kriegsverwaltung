package my_project.view;

import KAGO_framework.control.ViewController;
import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;
import my_project.control.ViewControll;

public class Europakarte extends GraphicalObject implements ButtonUser{

    private Button standortHinzufuegen;
    private ViewControll vC;

    public Europakarte(ViewController vCer, ViewControll vC){
        setNewImage("daten/zentraleuropa.jpeg");
        standortHinzufuegen = new Button("Füge hier einen Standort hinzu", 0,getMyImage().getHeight(),90,getMyImage().getWidth(),40,50,650, 100,0,0,0,this);
        registriereButtons(vCer);
        this.vC = vC;
    }

    public void draw(DrawTool drawTool){
        drawTool.drawImage(getMyImage(), 0, 0);
    }

    @Override
    public void update(double dt) {
        super.update(dt);
    }

    @Override
    public void buttoneffect(int buttonNummer) {
        if(buttonNummer == 0){
            new StandortErstellen(vC);
        }
    }

    @Override
    public void registriereButtons(ViewController vC) {
        vC.draw(standortHinzufuegen,1);
        vC.register(standortHinzufuegen,1);
    }
}
