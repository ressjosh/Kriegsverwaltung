package my_project.control;

import KAGO_framework.control.ViewController;
import my_project.view.Verwaltungsoptionen;
import my_project.view.Europakarte;
import my_project.view.Standortmarke;
import my_project.view.Startfenster;

public class ViewControll {
    private Startfenster startfenster;
    private Europakarte europakarte;
    private Verwaltungsoptionen verwaltungsoptionen;
    private ViewController vC;
    private CentralControll vS;
    private  SQLControll sC;

    public ViewControll(ViewController vC, CentralControll vS, SQLControll sC){
        this.sC = sC;
        this.vS = vS;
        this.vC = vC;
        vC.createScene();
        vC.createScene();
        startfenster = new Startfenster(vC,this);
        europakarte = new Europakarte(vC, this);
        verwaltungsoptionen = new Verwaltungsoptionen(vS);
        drawUndRegister();
    }

    private void drawUndRegister(){
        vC.draw(startfenster, 0);
        vC.draw(europakarte, 1);
        vC.draw(verwaltungsoptionen, 1);
        verwaltungsoptionen.registriereButtons(vC);
    }

    public void newStandort(String name, int y, int x, int iD, int kampfkraft){
        vS.erstelleNeuenStandort(name, "" + x, "" + y, ""+kampfkraft);
        Standortmarke tmp = new Standortmarke(y, x, this);
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

    public CentralControll getvS() {
        return vS;
    }
}
