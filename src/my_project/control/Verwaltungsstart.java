package my_project.control;

import KAGO_framework.control.ViewController;
import my_project.model.EuropakartenModel;

public class Verwaltungsstart {
    private EuropakartenModel ekM;
    private ViewControll vC;
    private ViewController viewController;
    private SQLControll sqlControll;

    public Verwaltungsstart(ViewController viewController){
        this.viewController = viewController;
        sqlControll = new SQLControll();
        vC = new ViewControll(viewController, this, sqlControll);
        ekM = new EuropakartenModel(vC);
    }

    //SQL-Umwandlung
    public void erstelleNeuenStandort(){

    }

    public void erstelleNeuePerson(){

    }

    public void erstelleNeuesFahrzeug(){

    }

    public void gibStandortDatenAus(int x, int y){
        //return sqlControll.processSQL("Hier steht bald der Befehl");
        //return "Hallo \n nochmal";
        sqlControll.processSQLMitRueckgabe("SQL um Standort mit bestimmten Koordinaten zurückzugeben");
    }

    public EuropakartenModel getEkM(){
        return ekM;
    }

    public void ausgabePersonenAlter(String alter){

    }
    public void ausgabePersonenNachname(String alter){

    }
    public void ausgabePersonenErkennungsnummer(String alter){

    }
    public void ausgabePersonenEinheit(String alter){

    }

    public void ausgabeFahrzeugeTyp(String typ){

    }
    public void ausgabeFahrzeugeBaujahr(String baujahr){

    }
    public void ausgabeFahrzeugeStationsort(String staionsort){

    }

}
