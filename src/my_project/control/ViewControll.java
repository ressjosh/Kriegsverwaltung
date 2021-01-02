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
    private List<standortmarke> standortmarken;
    private ViewController vC;
    private EuropakartenModel ekM;

    public ViewControll(ViewController vC, EuropakartenModel ekM){
        this.vC = vC;
        this.ekM = ekM;
        vC.createScene();
        vC.createScene();
        startfenster = new startfenster(vC,this);
        europakarte = new Europakarte(vC, this);
        verwaltungsoptionen = new Verwaltungsoptionen();
        standortmarken = new List<>();
        drawUndRegister();
    }

    private void drawUndRegister(){
        vC.draw(startfenster, 0);
        vC.draw(europakarte, 1);
        vC.draw(verwaltungsoptionen, 1);
    }

    public void newStandort(){
        standortmarke tmp = new standortmarke();
        ekM.standortHinzufuegen(tmp);
        vC.draw(tmp, 1);
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

}
