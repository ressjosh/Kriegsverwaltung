package my_project.view;

import KAGO_framework.control.ViewController;
import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;
import my_project.control.CentralControll;

public class Verwaltungsoptionen extends GraphicalObject implements ButtonUser {

    private Button personen, fahrzeuge, einheiten, kampfhandlungen, gesamtUebersicht, reconnecting;
    private Gesamtverwaltung gV;
    private CentralControll vS;
    private Aktionsmanager aM;

    public Verwaltungsoptionen(CentralControll vS) {
        this.vS = vS;
        aM = new Aktionsmanager(vS);
        personen = new Button("Personen- ", 932, 0,50,270,25,960,24,255,0,0,0,this);
        fahrzeuge = new Button("Fahrzeug- ", 932, 52,50,270,25,960,76,255,0,0,1,this);
        einheiten = new Button("Einheiten- ", 932, 104,50,270,25,960,128,255,0,0,2,this);
        kampfhandlungen = new Button("Kampfverwaltung", 932, 156,50,270,25,960,180,255,0,0,3,this);
        gesamtUebersicht = new Button("Alle Tabellen ", 932, 208,50,270,25,960,232,255,0,0,4,this);
        reconnecting = new Button("Reconnecting ", 932, 260,50,270,25,960,286,255,0,0,5,this);

        gV = new Gesamtverwaltung(vS);
    }

    @Override
    public void buttoneffect(int buttonNummer) {
        if(buttonNummer == 0){
            aM.setAktuelleTabelle(1);
            aM.setVisible(true);
        }else if(buttonNummer ==1){
            aM.setAktuelleTabelle(2);
            aM.setVisible(true);
        }else if(buttonNummer == 2){
            aM.setAktuelleTabelle(3);
            aM.setVisible(true);
        }else if(buttonNummer == 3){
            aM.setAktuelleTabelle(4);
            aM.setVisible(true);
        }else if(buttonNummer == 4){
            gV.setVisible(true);
        }else if(buttonNummer == 5){
            vS.reconnecting();
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
        vC.draw(gesamtUebersicht, 1);
        vC.draw(reconnecting, 1);
        vC.register(reconnecting,1);
        vC.register(personen,1);
        vC.register(fahrzeuge,1);
        vC.register(einheiten,1);
        vC.register(kampfhandlungen,1);
        vC.register(gesamtUebersicht, 1);

    }
}
