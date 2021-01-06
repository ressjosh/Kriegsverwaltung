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
        sqlControll.processSQL("INSERT INTO JR_Kv_Standorte " +
                "                VALUES " +
                "                ("+iD+", "+koordinate01+", "+koordinate02+", "+gesamtkampfkraft+
                "                ;");
        sqlControll.processSQLMitRueckgabe("SELECT * FROM JR_Kv_Standorte WHERE ID =  " + iD + "; ");

    }

    public void erstelleNeuePerson(String erkennungsnummer, String vorname, String nachname, String age, String geschlecht, String geburtsjahr, String einheit, String straße, String hausnummer, String plz, String stadt, String land){
        sqlControll.processSQL("INSERT INTO JR_Kv_Personen " +
                "                VALUES " +
                "                ('"+erkennungsnummer+"', '"+vorname+"', '"+nachname+"', "+age+", '"+geschlecht+"', '"+geburtsjahr+"', "+einheit+"," +
                "                 true, false, '"+straße+"', "+hausnummer+", "+plz+", '"+stadt+"'," +
                "                 '"+land+"') " +
                "                ;");
        sqlControll.processSQLMitRueckgabe("SELECT * FROM JR_Kv_Einheit JOIN JR_Kv_Personen ON JR_Kv_Personen.einheit = JR_Kv_Einheit.ID WHERE Erkennungsnummer =  " + erkennungsnummer + "; ");

    }

    public void erstelleNeuesFahrzeug(String iD, String typ, String baujahr,  String fahrzeugfuehrer, String stationsort, String besatzung){
        sqlControll.processSQLMitRueckgabe("INSERT INTO JR_Kv_Fahrzeuge " +
                "VALUES" +
                "("+iD+", '" + typ + "', " + baujahr + ", ' "+fahrzeugfuehrer+"', " +stationsort + ", false, ' "+ besatzung + "' )");
        sqlControll.processSQLMitRueckgabe("SELECT * FROM JR_Kv_Fahrzeuge JOIN JR_Kv_Besatzung ON JR_Kv_Fahrzeuge.Besatzung = JR_Kv_Besatzung.Spitzname WHERE ID = " + iD + "; ");

    }

    public void erstelleNeueKampfhandlung(String codename, String standort, String beschreibung, String opferzahl, String feind, String[] einheiten){
        System.out.println(sqlControll.processSQL("INSERT INTO JR_Kv_Kampfhandlung " +
                "VALUES " +
                "(' " + codename + "' , " + standort + ", '" + beschreibung +"' , " + opferzahl + ", " + feind  +
                ");"));
            for(int i = 0; i < einheiten.length; i++){

;                System.out.println(sqlControll.processSQL("INSERT INTO JR_Kv_KämpfendeTruppe " +
                        "VALUES " +
                        "( " + codename + " , " + einheiten[i] +
                        ");"));

            }

        sqlControll.processSQLMitRueckgabe("SELECT * FROM JR_Kv_Kampfhandlung WHERE Codename = ' " + codename + "' ");

    }

    public void erstelleNeueEinheit(String iD, String truppstaerke, String oberbefehlshaber, String erfahrungwert, String kampfkraft, String imEinsatz){
        sqlControll.processSQL("INSERT INTO JR_Kv_Einheit " +
                "                VALUES " +
                "                ("+iD+", "+truppstaerke+", "+oberbefehlshaber+", "+erfahrungwert+", "+kampfkraft+"," +imEinsatz+
                "                );");
        sqlControll.processSQLMitRueckgabe("SELECT * FROM JR_Kv_Einheit JOIN JR_Kv_Personen ON JR_Kv_Einheit.Oberbefehlshaber = JR_Kv_Personen.Erkennungsnummer WHERE ID = ' " + iD + "' ");
    }

    //Methoden zur Ausgabe einzelner Datensätze

    public void gibStandortDatenAus(int x, int y){
        sqlControll.processSQLMitRueckgabe("SELECT * FROM JR_Kv_Standorte WHERE Koordinate01 = " + x + "AND Koordinate02 = " + y + ";");
    }




    public void ausgabePersonenEinParameter( String Attribut, String Attributwert){
        sqlControll.processSQLMitRueckgabe("SELECT ID, Vorname, Nachname, Age, " +
                " Geschlecht, Land, Stadt, Einheit, Oberbefehlshaber AS Vorgesetzter  " +
                " FROM JR_Kv_Personen JOIN JR_Kv_Einheit ON JR_Kv_Personen.Einheit = JR_Kv_Einheit.ID" +
                " WHERE " + Attribut + " LIKE '" + Attributwert + "';");
    }

    public void ausgabePersonenZweiParameter(String Attribut01, String Attributwert01, String Attribut02, String Attributwert02){
        sqlControll.processSQLMitRueckgabe("SELECT ID, Vorname, Nachname, Age, " +
                " Geschlecht, Land, Stadt, Einheit, Oberbefehlshaber AS Vorgesetzter  " +
                " FROM JR_Kv_Personen JOIN JR_Kv_Einheit ON JR_Kv_Personen.Einheit = JR_Kv_Einheit.ID" +
                " WHERE " + Attribut01 + " LIKE '" + Attributwert01 + "' AND " + Attribut02 + " LIKE '" + Attributwert02+ "' ;");
    }

    public void ausgabePersonenDreiParameter(String Attribut01, String Attributwert01,String Attribut02, String Attributwert02,String Attribut03, String Attributwert03){
        sqlControll.processSQLMitRueckgabe("SELECT ID, Vorname, Nachname, Age, " +
                " Geschlecht, Land, Stadt, Einheit, Oberbefehlshaber AS Vorgesetzter  " +
                " FROM JR_Kv_Personen JOIN JR_Kv_Einheit ON JR_Kv_Personen.Einheit = JR_Kv_Einheit.ID" +
                " WHERE " + Attribut01 + " LIKE '" + Attributwert01 + "' AND " + Attribut02 + " LIKE '" + Attributwert02+ "' AND "+ Attribut03 + " LIKE '" + Attributwert03+ "';");
    }

    public void ausgabePersonenVierParameter(String Attribut01, String Attributwert01,String Attribut02, String Attributwert02,String Attribut03, String Attributwert03,String Attribut04, String Attributwert04){
        sqlControll.processSQLMitRueckgabe("SELECT ID, Vorname, Nachname, Age, " +
                " Geschlecht, Land, Stadt, Einheit, Oberbefehlshaber AS Vorgesetzter  " +
                " FROM JR_Kv_Personen JOIN JR_Kv_Einheit ON JR_Kv_Personen.Einheit = JR_Kv_Einheit.ID" +
                " WHERE " + Attribut01 + " LIKE '" + Attributwert01 + "' AND " + Attribut02 + " LIKE '" + Attributwert02+ "' AND "+ Attribut03 + " LIKE '" + Attributwert03+ "' AND " + Attribut04 + " LIKE '" + Attributwert04+ "' ;");
    }

    public void ausgabeFahrzeugeEinParameter( String Attribut, String Attributwert){
       sqlControll.processSQLMitRueckgabe("SELECT ID, Baujahr,  FROM JR_Kv_Fahrzeuge"  + " WHERE " + Attribut + " LIKE '" + Attributwert + "';");
    }

    public void ausgabeFahrzeugeZweiParameter( String Attribut01, String Attributwert01, String Attribut02, String Attributwert02){
        sqlControll.processSQLMitRueckgabe("SELECT * FROM JR_Kv_Fahrzeuge"  + " WHERE " + Attribut01 + " LIKE '" + Attributwert01 + "' AND " + Attribut02 + " LIKE '" + Attributwert02+ "' ;");
    }

    public void ausgabeFahrzeugeDreiParameter(String Attribut01, String Attributwert01,String Attribut02, String Attributwert02,String Attribut03, String Attributwert03){
        sqlControll.processSQLMitRueckgabe("SELECT * FROM JR_Kv_Fahrzeuge"  + " WHERE " + Attribut01 + " LIKE '" + Attributwert01 + "' AND " + Attribut02 + " LIKE '" + Attributwert02+ "' AND "+ Attribut03 + " LIKE '" + Attributwert03+ "';");
    }

    public void ausgabeFahrzeugeVierParameter(String Attribut01, String Attributwert01,String Attribut02, String Attributwert02,String Attribut03, String Attributwert03,String Attribut04, String Attributwert04){
        sqlControll.processSQLMitRueckgabe("SELECT * FROM JR_Kv_Fahrzeuge"  + " WHERE " + Attribut01 + " LIKE '" + Attributwert01 + "' AND " + Attribut02 + " LIKE '" + Attributwert02+ "' AND "+ Attribut03 + " LIKE '" + Attributwert03+ "' AND " + Attribut04 + " LIKE '" + Attributwert04+ "' ;");
    }

    public void ausgabeKampfhandlungEinParameter( String Attribut, String Attributwert){
        System.out.println("SELECT * FROM JR_Kv_Personen WHERE " + Attribut + " LIKE " + Attributwert + ";");
        sqlControll.processSQLMitRueckgabe("SELECT * FROM JR_Kv_Kampfhandlung"  + " WHERE " + Attribut + " LIKE '" + Attributwert + "';");
    }

    public void ausgabeKampfhandlungZweiParameter(String Attribut01, String Attributwert01, String Attribut02, String Attributwert02){
        sqlControll.processSQLMitRueckgabe("SELECT * FROM JR_Kv_Kampfhandlung"  + " WHERE " + Attribut01 + " LIKE '" + Attributwert01 + "' AND " + Attribut02 + " LIKE '" + Attributwert02+ "' ;");
    }





    public void ausgabeEinheitMindestErfahrung(String parameterwert){
        sqlControll.processSQLMitRueckgabe("SELECT * FROM JR_Kv_Einheit WHERE Erfahrung " + "<" + parameterwert + ";");
    }

    public void ausgabeEinheitMindestKampfkraft(String parameterwert){
        sqlControll.processSQLMitRueckgabe("SELECT * FROM JR_Kv_Einheit WHERE Kampfkraft =" + parameterwert + ";");
    }

    public void ausgabeEinheitID(String parameterwert){
        sqlControll.processSQLMitRueckgabe("SELECT * FROM JR_Kv_Einheit WHERE ID =" + parameterwert + ";");
    }

    //Methoden um alle Datensätze auszugeben

    public void showAll(String tabelle){
        sqlControll.processSQLMitRueckgabe("SELECT * " +
                "FROM JR_Kv_"+tabelle+";");
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
