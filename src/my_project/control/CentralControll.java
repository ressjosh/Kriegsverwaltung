package my_project.control;

import KAGO_framework.control.ViewController;
import my_project.model.EuropakartenModel;

public class CentralControll {
    private EuropakartenModel ekM;
    private ViewControll vC;
    private ViewController viewController;
    private SQLControll sqlControll;

    public CentralControll(ViewController viewController){
        this.viewController = viewController;
        sqlControll = new SQLControll();
        vC = new ViewControll(viewController, this, sqlControll);
        ekM = new EuropakartenModel(vC);
    }

    public EuropakartenModel getEkM(){
        return ekM;
    }

    //SQL-Umwandlung

    //Methoden zur Erstellung eines neuen Datensatzes
    public void erstelleNeuenStandort(){

    }

    public void erstelleNeuePerson(){

    }

    public void erstelleNeuesFahrzeug(){

    }

    public void erstelleNeueKampfhandlung(){

    }

    public void erstelleNeueEinheit(){

    }

    //Methoden zur Ausgabe einzelner Datensätze

    public void gibStandortDatenAus(int x, int y){
        sqlControll.processSQLMitRueckgabe("SQL um Standort mit bestimmten Koordinaten zurückzugeben");
    }

    public void ausgabePersonEinParameter(String Attribut, String Attributwert){
        sqlControll.processSQLMitRueckgabe("");
    }

    public void ausgabePersonZweiParameter(String Attribut01, String Attributwert01, String Attribut02, String Attributwert02){
        sqlControll.processSQLMitRueckgabe("");
    }

    public void ausgabePersonDreiParameter(String Attribut01, String Attributwert01,String Attribut02, String Attributwert02,String Attribut03, String Attributwert03){
        sqlControll.processSQLMitRueckgabe("");
    }

    public void ausgabePersonVierParameter(String Attribut01, String Attributwert01,String Attribut02, String Attributwert02,String Attribut03, String Attributwert03,String Attribut04, String Attributwert04){
        sqlControll.processSQLMitRueckgabe("");
    }

    public void ausgabeFahrzeugEinParameter(String Attribut, String Attributwert){
        sqlControll.processSQLMitRueckgabe("");
    }

    public void ausgabeFahrzeugZweiParameter(String Attribut01, String Attributwert01, String Attribut02, String Attributwert02){
        sqlControll.processSQLMitRueckgabe("");
    }

    public void ausgabeFahrzeugDreiParameter(String Attribut01, String Attributwert01,String Attribut02, String Attributwert02,String Attribut03, String Attributwert03){
        sqlControll.processSQLMitRueckgabe("");
    }

    public void ausgabeFahrzeugVierParameter(String Attribut01, String Attributwert01,String Attribut02, String Attributwert02,String Attribut03, String Attributwert03,String Attribut04, String Attributwert04){
        sqlControll.processSQLMitRueckgabe("");
    }

    public void ausgabeKampfhandlungEinParameter(String Attribut, String Attributwert){
        sqlControll.processSQLMitRueckgabe("");
    }

    public void ausgabeKampfhandlungZweiParameter(String Attribut01, String Attributwert01, String Attribut02, String Attributwert02){
        sqlControll.processSQLMitRueckgabe("");
    }

    public void ausgabeEinheitMindestErfahrung(){

    }

    public void ausgabeEinheitMindestKampfkraft(){

    }

    public void ausgabeEinheitID(){

    }

    //Methoden um alle Datensätze auszugeben

    public void showAllPersonen(){

    }

    public void showAllFahrzeuge(){

    }

    public void showAllKampfhandlungen(){

    }

    public void showAllEinheiten(){

    }

    public void showAllFahrzeugtypen(){

    }

    public void showAllBesatzungen(){

    }

    public void showAllFeinde(){

    }

    //Methoden um bestimmten Datensatz zu löschen

    public void deleteFahrzeug(String IDZuloeschen){

    }

    public void deletePerson(String IDZuloeschen){

    }

    public void deleteEinheit(String IDZuloeschen){

    }

    public void deleteKampfhandlung(String IDZuloeschen){

    }

}
