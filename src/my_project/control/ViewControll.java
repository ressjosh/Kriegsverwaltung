package my_project.control;

import KAGO_framework.control.ViewController;
import KAGO_framework.model.abitur.datenstrukturen.List;
import my_project.model.EuropakartenModel;
import my_project.view.Verwaltungsoptionen;
import my_project.view.Europakarte;
import my_project.view.standortmarke;
import my_project.view.startfenster;

public class ViewControll {
    private startfenster startfenster;
    private Europakarte europakarte;
    private Verwaltungsoptionen verwaltungsoptionen;
    private ViewController vC;
    private Verwaltungsstart vS;
    private  SQLControll sC;

    public ViewControll(ViewController vC,Verwaltungsstart vS, SQLControll sC){
        this.sC = sC;
        this.vS = vS;
        this.vC = vC;
        vC.createScene();
        vC.createScene();
        startfenster = new startfenster(vC,this);
        europakarte = new Europakarte(vC, this);
        verwaltungsoptionen = new Verwaltungsoptionen();
        drawUndRegister();
    }

    private void drawUndRegister(){
        vC.draw(startfenster, 0);
        vC.draw(europakarte, 1);
        vC.draw(verwaltungsoptionen, 1);
        verwaltungsoptionen.registriereButtons(vC);
    }

    public void newStandort(String name, int y, int x, int iD, int kampfkraft){
        vS.erstelleNeuenStandort();
        standortmarke tmp = new standortmarke(y, x, this);
        vS.getEkM().standortHinzufuegen(tmp);
        vC.draw(tmp, 1);
        vC.register(tmp, 1);
    }

    public void starteMusik(int welche){
        if(vC.getSoundController().isPlaying("music01")) vC.getSoundController().stopSound("music01");
        if(vC.getSoundController().isPlaying("music02")) vC.getSoundController().stopSound("music02");

        if(welche == 1){
            vC.getSoundController().playSound("music01");
            vC.getSoundController().setVolume("music01", 1);
        }else if(welche == 2){
            vC.getSoundController().playSound("music02");
            vC.getSoundController().setVolume("music02", 1);
        }

    }

    public Verwaltungsstart getvS() {
        return vS;
    }
}
