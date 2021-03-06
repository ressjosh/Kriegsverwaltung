package my_project.model;

import KAGO_framework.model.abitur.datenstrukturen.List;
import my_project.control.ViewControll;
import my_project.view.Standortmarke;

public class EuropakartenModel {

    private List<Standortmarke> standortmarken;
    private ViewControll vC;

    public EuropakartenModel(ViewControll viewControll){
        vC = viewControll;
        standortmarken = new List<>();
    }

    public void standortHinzufuegen(Standortmarke sm){
        standortmarken.append(sm);
    }
}
