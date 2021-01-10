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

    public void erstelleNeuenStandort(String iD, String koordinate01, String koordinate02, String gesamtkampfkraft, String name){
        System.out.println(sqlControll.processSQL("INSERT INTO JR_Kv_Standorte " +
                "                VALUES " +
                "                ("+iD+", "+koordinate01+", "+koordinate02+", "+gesamtkampfkraft+ ", '" + name + "'"+
                "                );"));
        sqlControll.processSQLMitRueckgabe("SELECT * FROM JR_Kv_Standorte WHERE ID =  " + iD + "; ");

    }

    public void erstelleNeuePerson(String erkennungsnummer, String vorname, String nachname, String age, String geschlecht, String geburtsjahr, String einheit, String straße, String hausnummer, String plz, String stadt, String land){
        System.out.println(sqlControll.processSQL("INSERT INTO JR_Kv_Personen " +
                "                VALUES " +
                "                ('"+erkennungsnummer+"', '"+vorname+"', '"+nachname+"', "+age+", '"+geschlecht+"', '"+geburtsjahr+"', "+einheit+"," +
                "                 true, false, '"+straße+"', "+hausnummer+", "+plz+", '"+stadt+"'," +
                "                 '"+land+"') " +
                "                ;"));

        sqlControll.processSQLMitRueckgabe("SELECT Erkennungsnummer, Vorname, Nachname, Age, " +
                " Geschlecht, Land, Stadt, Einheit, Oberbefehlshaber AS Vorgesetzter  " +
                " FROM JR_Kv_Personen JOIN JR_Kv_Einheit ON JR_Kv_Personen.Einheit = JR_Kv_Einheit.ID" +
                " WHERE Erkennungsnummer =  " + erkennungsnummer + "; ");


    }

    public void erstelleNeuesFahrzeug(String iD, String typ, String besatzung,  String fahrzeugfuehrer, String stationsort, String baujahr){
        System.out.println(sqlControll.processSQL("INSERT INTO JR_Kv_Fahrzeuge " +
                "VALUES" +
                "("+iD+", '" + typ + "', " + baujahr + ",  "+fahrzeugfuehrer+", " +stationsort + ", false,  '"+ besatzung + "' );"));

        sqlControll.processSQLMitRueckgabe("SELECT * FROM JR_Kv_Fahrzeuge JOIN JR_Kv_Besatzung ON JR_Kv_Fahrzeuge.Besatzung = JR_Kv_Besatzung.ID WHERE JR_Kv_Fahrzeuge.ID = " + iD + "; ");

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
        sqlControll.processSQLMitRueckgabe("SELECT * FROM JR_Kv_Standorte " +
                "WHERE Koordinate01 = " + x + " AND Koordinate02 = " + y + ";");
    }




    public void ausgabePersonenEinParameter( String Attribut, String Attributwert){
        sqlControll.processSQLMitRueckgabe("SELECT Erkennungsnummer, Vorname, Nachname, Age, " +
                " Geschlecht, Land, Stadt, Einheit, Oberbefehlshaber AS Vorgesetzter  " +
                " FROM JR_Kv_Personen JOIN JR_Kv_Einheit ON JR_Kv_Personen.Einheit = JR_Kv_Einheit.ID" +
                " WHERE " + Attribut + " LIKE '" + Attributwert + "';");
    }

    public void ausgabePersonenZweiParameter(String Attribut01, String Attributwert01, String Attribut02, String Attributwert02){
        sqlControll.processSQLMitRueckgabe("SELECT Erkennungsnummer, Vorname, Nachname, Age, " +
                " Geschlecht, Land, Stadt, Einheit, Oberbefehlshaber AS Vorgesetzter  " +
                " FROM JR_Kv_Personen JOIN JR_Kv_Einheit ON JR_Kv_Personen.Einheit = JR_Kv_Einheit.ID" +
                " WHERE " + Attribut01 + " LIKE '" + Attributwert01 + "' AND " + Attribut02 + " LIKE '" + Attributwert02+ "' ;");
    }

    public void ausgabePersonenDreiParameter(String Attribut01, String Attributwert01,String Attribut02, String Attributwert02,String Attribut03, String Attributwert03){
        sqlControll.processSQLMitRueckgabe("SELECT Erkennungsnummer, Vorname, Nachname, Age, " +
                " Geschlecht, Land, Stadt, Einheit, Oberbefehlshaber AS Vorgesetzter  " +
                " FROM JR_Kv_Personen JOIN JR_Kv_Einheit ON JR_Kv_Personen.Einheit = JR_Kv_Einheit.ID" +
                " WHERE " + Attribut01 + " LIKE '" + Attributwert01 + "' AND " + Attribut02 + " LIKE '" + Attributwert02+ "' AND "+ Attribut03 + " LIKE '" + Attributwert03+ "';");
    }

    public void ausgabePersonenVierParameter(String Attribut01, String Attributwert01,String Attribut02, String Attributwert02,
                                             String Attribut03, String Attributwert03,String Attribut04, String Attributwert04){
        sqlControll.processSQLMitRueckgabe("SELECT Erkennungsnummer, Vorname, Nachname, Age, " +
                " Geschlecht, Land, Stadt, Einheit, Oberbefehlshaber AS Vorgesetzter  " +
                " FROM JR_Kv_Personen JOIN JR_Kv_Einheit ON JR_Kv_Personen.Einheit = JR_Kv_Einheit.ID" +
                " WHERE " + Attribut01 + " LIKE '" + Attributwert01 + "' AND " + Attribut02 + " LIKE '" + Attributwert02+ "' " +
                "AND "+ Attribut03 + " LIKE '" + Attributwert03+ "' AND " + Attribut04 + " LIKE '" + Attributwert04+ "' ;");
    }

    public void ausgabeFahrzeugeEinParameter( String Attribut, String Attributwert){
       sqlControll.processSQLMitRueckgabe("SELECT JR_Kv_Fahrzeuge.ID AS ID , Baujahr, JR_Kv_FahrzeugeTypen.Typ AS Typ, Fahrzeugart, PS, Kampfkraft, Vorname, Nachname, Stationsort, Koordinate01, Koordinate02" +
               " FROM ((JR_Kv_Fahrzeuge " +
               "JOIN JR_Kv_Fahrzeugtypen ON JR_Kv_Fahrzeuge.Typ = JR_Kv_Fahrzeugtypen.ID) " +
               "JOIN JR_Kv_Personen ON JR_Kv_Fahrzeuge.Fahrzeugführer = JR_Kv_Personen.Erkennungsnummer) " +
               "JOIN JR_Kv_Standorte ON JR_Kv_Fahrzeuge.Stationsort = JR_Kv_Standorte.ID "  +
               " WHERE " + Attribut + " LIKE '" + Attributwert + "';");
    }

    public void ausgabeFahrzeugeZweiParameter( String Attribut01, String Attributwert01, String Attribut02, String Attributwert02){
        sqlControll.processSQLMitRueckgabe("SELECT JR_Kv_Fahrzeuge.ID AS ID , Baujahr, JR_Kv_FahrzeugeTypen.Typ AS Typ, Fahrzeugart, PS, Kampfkraft, Vorname, Nachname, Stationsort, Koordinate01, Koordinate02" +
                " FROM ((JR_Kv_Fahrzeuge " +
                "JOIN JR_Kv_Fahrzeugtypen ON JR_Kv_Fahrzeuge.Typ = JR_Kv_Fahrzeugtypen.ID) " +
                "JOIN JR_Kv_Personen ON JR_Kv_Fahrzeuge.Fahrzeugführer = JR_Kv_Personen.Erkennungsnummer) " +
                "JOIN JR_Kv_Standorte ON JR_Kv_Fahrzeuge.Stationsort = JR_Kv_Standorte.ID "  +
                " WHERE " + Attribut01 + " LIKE '" + Attributwert01 + "' AND " + Attribut02 + " LIKE '" + Attributwert02+ "' ;");
    }

    public void ausgabeFahrzeugeDreiParameter(String Attribut01, String Attributwert01,String Attribut02, String Attributwert02,String Attribut03, String Attributwert03){
        sqlControll.processSQLMitRueckgabe("SELECT JR_Kv_Fahrzeuge.ID AS ID , Baujahr, JR_Kv_FahrzeugeTypen.Typ AS Typ, Fahrzeugart, PS, Kampfkraft, Vorname, Nachname, Stationsort, Koordinate01, Koordinate02" +
                " FROM ((JR_Kv_Fahrzeuge " +
                "JOIN JR_Kv_Fahrzeugtypen ON JR_Kv_Fahrzeuge.Typ = JR_Kv_Fahrzeugtypen.ID) " +
                "JOIN JR_Kv_Personen ON JR_Kv_Fahrzeuge.Fahrzeugführer = JR_Kv_Personen.Erkennungsnummer) " +
                "JOIN JR_Kv_Standorte ON JR_Kv_Fahrzeuge.Stationsort = JR_Kv_Standorte.ID "  +
                " WHERE " + Attribut01 + " LIKE '" + Attributwert01 + "' AND " + Attribut02 + " LIKE '" + Attributwert02+ "' AND "+ Attribut03 + " LIKE '" + Attributwert03+ "';");
    }

    public void ausgabeFahrzeugeVierParameter(String Attribut01, String Attributwert01,String Attribut02, String Attributwert02,String Attribut03, String Attributwert03,String Attribut04, String Attributwert04){
        sqlControll.processSQLMitRueckgabe("SELECT JR_Kv_Fahrzeuge.ID AS ID , Baujahr, JR_Kv_FahrzeugeTypen.Typ AS Typ, Fahrzeugart, PS, Kampfkraft, Vorname, Nachname, Stationsort, Koordinate01, Koordinate02" +
                " FROM ((JR_Kv_Fahrzeuge " +
                "JOIN JR_Kv_Fahrzeugtypen ON JR_Kv_Fahrzeuge.Typ = JR_Kv_Fahrzeugtypen.ID) " +
                "JOIN JR_Kv_Personen ON JR_Kv_Fahrzeuge.Fahrzeugführer = JR_Kv_Personen.Erkennungsnummer) " +
                "JOIN JR_Kv_Standorte ON JR_Kv_Fahrzeuge.Stationsort = JR_Kv_Standorte.ID "  +
                " WHERE " + Attribut01 + " LIKE '" + Attributwert01 + "' AND " + Attribut02 + " LIKE '" + Attributwert02+ "' AND "+ Attribut03 + " LIKE '" + Attributwert03+ "' AND " + Attribut04 + " LIKE '" + Attributwert04+ "' ;");
    }

    public void ausgabeKampfhandlungEinParameter( String Attribut, String Attributwert){
        System.out.println("SELECT Codename, Standort, Beschreibung, JR_Kv_Feinde.Name AS Feind, JR_Kv_Einheit.ID AS Beteiligteeinheiten   FROM JR_Kv_Personen WHERE " + Attribut + " LIKE " + Attributwert + ";");
        sqlControll.processSQLMitRueckgabe("SELECT JR_Kv_Kampfhandlung.Codename, Standort, Beschreibung, JR_Kv_Feinde.Name AS Feind, JR_Kv_Einheit.ID AS Beteiligteeinheiten " +
                " FROM ((JR_Kv_Kampfhandlung " +
                "JOIN JR_Kv_Feinde ON JR_Kv_Kampfhandlung.Feind = JR_Kv_Feinde.ID)" +
                "JOIN JR_Kv_KämpfendeTruppe ON JR_Kv_Kampfhandlung.Codename = JR_Kv_KämpfendeTruppe.Codename)" +
                "JOIN JR_Kv_Einheit ON JR_Kv_KämpfendeTruppe.Einheit = JR_Kv_Einheit.ID" +
                " WHERE " + Attribut + " LIKE '" + Attributwert + "';");
    }

    public void ausgabeKampfhandlungZweiParameter(String Attribut01, String Attributwert01, String Attribut02, String Attributwert02){
        sqlControll.processSQLMitRueckgabe("SELECT JR_Kv_Kampfhandlung.Codename, Standort, Beschreibung, JR_Kv_Feinde.Name AS Feind, JR_Kv_Einheit.ID AS Beteiligteeinheiten " +
                " FROM ((JR_Kv_Kampfhandlung " +
                "JOIN JR_Kv_Feinde ON JR_Kv_Kampfhandlung.Feind = JR_Kv_Feinde.ID)" +
                "JOIN JR_Kv_KämpfendeTruppe ON JR_Kv_Kampfhandlung.Codename = JR_Kv_KämpfendeTruppe.Codename)" +
                "JOIN JR_Kv_Einheit ON JR_Kv_KämpfendeTruppe.Einheit = JR_Kv_Einheit.ID" +
                " WHERE " + Attribut01 + " LIKE '" + Attributwert01 + "' AND " + Attribut02 + " LIKE '" + Attributwert02+ "' ;");
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

    //TODO Löschen erarbeiten sowie Bugfix im gesamten Programm betreiben,
    // außerdem letzte Viewverschönerungen
    // ER- und UML-diagramm
    // Präsentation und Codespotlights

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

    public void bearbeiteDatensatz(String namePrimaryKey, String primaryKey, String tabelle, String attribut, String attributwert){
        sqlControll.processSQL("UPDATE JR_Kv_"+ tabelle + " SET " + attribut + " = '" + attributwert + "'" +
                " WHERE " + namePrimaryKey + " = '" + primaryKey + "';");
        sqlControll.processSQLMitRueckgabe("SELECT * FROM JR_Kv_" + tabelle + " WHERE " + namePrimaryKey + " =  " + primaryKey + "; ");
    }

    public void reconnecting(){
        if(sqlControll.reconnecting()){
            System.out.println("-----------------------------------Successfull reconnnected!-------------------------------");
        }else{
            System.out.println("-----------------------------------Connection failed-------------------------------");
        }
    }

}
