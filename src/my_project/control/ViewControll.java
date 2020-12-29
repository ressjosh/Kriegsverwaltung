package my_project.control;

import KAGO_framework.control.ViewController;
import KAGO_framework.model.abitur.datenstrukturen.List;
import my_project.model.EuropakartenModel;
import my_project.view.Verwaltungsoptionen;
import my_project.view.europakarte;
import my_project.view.standortmarke;
import my_project.view.startfenster;

public class ViewControll {
    private startfenster startfenster;
    private europakarte europakarte;
    private Verwaltungsoptionen verwaltungsoptionen;
    private List<standortmarke> standortmarken;
    private ViewController vC;
    private EuropakartenModel ekM;

    public ViewControll(ViewController vC, EuropakartenModel ekM){
        this.vC = vC;
        this.ekM = ekM;
        vC.createScene();
        vC.createScene();
        startfenster = new startfenster();
        europakarte = new europakarte();
        verwaltungsoptionen = new Verwaltungsoptionen();
        standortmarken = new List<>();
        drawUndRegister();
    }

    private void drawUndRegister(){
        vC.draw(startfenster, 0);
        vC.draw(europakarte, 1);
        vC.draw(verwaltungsoptionen, 1);
    }

    private void newStandort(){
        standortmarke tmp = new standortmarke();
        ekM.standortHinzufuegen(tmp);
        vC.draw(tmp, 1);
    }

}
