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

    public void erstelleNeuenStandort(String iD, String koordinate01, String koordinate02, String gesamtkampfkraft){
        sqlControll.processSQLMitRueckgabe("");
    }

    public void erstelleNeuePerson(String erkennungsnummer, String vorname, String nachname, String age, String geschlecht, String geburtsjahr, String einheit, String straße, String hausnummer, String plz, String stadt, String land){
        sqlControll.processSQLMitRueckgabe("");
    }

    public void erstelleNeuesFahrzeug(String iD, String typ, String baujahr,  String fahrzeugfuehrer, String stationsort, String besatzung){
        sqlControll.processSQLMitRueckgabe("");
    }

    public void erstelleNeueKampfhandlung(String codename, String standort, String beschreibung, String opferzahl, String feind, String[] einheiten){
        sqlControll.processSQLMitRueckgabe("");
    }

    public void erstelleNeueEinheit(String iD, String truppstaerke, String oberbefehlshaber, String erfahrungwert, String kampfkraft, String imEinsatz){
        sqlControll.processSQLMitRueckgabe("");
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

    public void ausgabeEinheitMindestErfahrung(String parameterwert){
        sqlControll.processSQLMitRueckgabe("");
    }

    public void ausgabeEinheitMindestKampfkraft(String parameterwert){
        sqlControll.processSQLMitRueckgabe("");
    }

    public void ausgabeEinheitID(String parameterwert){
        sqlControll.processSQLMitRueckgabe("");
    }

    //Methoden um alle Datensätze auszugeben

    public void showAllPersonen(){
        sqlControll.processSQLMitRueckgabe("");
    }

    public void showAllFahrzeuge(){
        sqlControll.processSQLMitRueckgabe("");
    }

    public void showAllKampfhandlungen(){
        sqlControll.processSQLMitRueckgabe("");
    }

    public void showAllEinheiten(){
        sqlControll.processSQLMitRueckgabe("");
    }

    public void showAllFahrzeugtypen(){
        sqlControll.processSQLMitRueckgabe("");
    }

    public void showAllBesatzungen(){
        sqlControll.processSQLMitRueckgabe("");
    }

    public void showAllFeinde(){
        sqlControll.processSQLMitRueckgabe("");
    }

    //Methoden um bestimmten Datensatz zu löschen

    public void deleteFahrzeug(String IDZuloeschen){
        sqlControll.processSQLMitRueckgabe("");
    }

    public void deletePerson(String IDZuloeschen){
        sqlControll.processSQLMitRueckgabe("");
    }

    public void deleteEinheit(String IDZuloeschen){
        sqlControll.processSQLMitRueckgabe("");
    }

    public void deleteKampfhandlung(String IDZuloeschen){
        sqlControll.processSQLMitRueckgabe("");
    }

}
