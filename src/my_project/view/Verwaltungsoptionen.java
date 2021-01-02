package my_project.view;

import KAGO_framework.control.ViewController;
import KAGO_framework.model.GraphicalObject;
import KAGO_framework.model.InteractiveGraphicalObject;
import KAGO_framework.view.DrawTool;
import my_project.control.Verwaltungsstart;

import java.awt.event.MouseEvent;

public class Verwaltungsoptionen extends GraphicalObject implements ButtonUser {

    private Button personen, fahrzeuge, einheiten, kampfhandlungen;
    private Personenverwaltung pV;
    private Kampfverwaltung kV;
    private Einheitenverwaltung eV;
    private Fahrzeugverwaltung fV;
    private Verwaltungsstart vS;

    public Verwaltungsoptionen(Verwaltungsstart vS) {
        this.vS = vS;
        personen = new Button("Personen- ", 932, 0,50,250,25,960,24,255,0,0,0,this);
        fahrzeuge = new Button("Fahrzeug- ", 932, 52,50,250,25,960,76,255,0,0,1,this);
        einheiten = new Button("Einheiten- ", 932, 104,50,250,25,960,128,255,0,0,2,this);
        kampfhandlungen = new Button("Kampfverwaltung", 932, 156,50,250,25,960,180,255,0,0,3,this);
        pV = new Personenverwaltung(vS);
        fV = new Fahrzeugverwaltung(vS);
        kV = new Kampfverwaltung();
        eV = new Einheitenverwaltung();
    }

    @Override
    public void buttoneffect(int buttonNummer) {
        if(buttonNummer == 0){
            pV.setVisible(true);
        }else if(buttonNummer ==1){
            fV.setVisible(true);
        }else if(buttonNummer == 2){
            eV.setVisible(true);
        }else if(buttonNummer == 3){
            kV.setVisible(true);
        }

    }

    @Override
    public void draw(DrawTool drawTool) {
        super.draw(drawTool);
    }

    @Override
    public void update(double dt) {
        super.update(dt);
    }

    @Override
    public void registriereButtons(ViewController vC) {
        vC.draw(personen,1);
        vC.draw(fahrzeuge,1);
        vC.draw(einheiten,1);
        vC.draw(kampfhandlungen,1);
        vC.register(personen,1);
        vC.register(fahrzeuge,1);
        vC.register(einheiten,1);
        vC.register(kampfhandlungen,1);
    }
}
