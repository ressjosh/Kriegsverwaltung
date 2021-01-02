package my_project.control;

import KAGO_framework.control.DatabaseController;
import KAGO_framework.model.abitur.datenbanken.mysql.QueryResult;
import my_project.view.Ausgabenformatierung;

public class SQLControll {

    private DatabaseController dbController;

    public SQLControll(){
        dbController = new DatabaseController();
        programmstart();
    }

    public void programmstart() {
        if(dbController.connect()) {
            loescheTabellen();
            erstelleTabellen();
        }
    }

    public void processSQLMitRueckgabe(String sql){
        String ergebnis = processSQL(sql);
        if(ergebnis.equals("Success")){
            String [][] ausgabe = dbController.getCurrentQueryResult().getData();
            String[][] tmp = new String[ausgabe.length+1][];
            tmp[0] = dbController.getCurrentQueryResult().getColumnNames();
            for(int i = 1; i<tmp.length; i++){
                tmp[i] = ausgabe[i-1];
            }
            new Ausgabenformatierung(tmp);
        }else{
            String[][] tmp = new String[1][1];
            tmp[0][0] = ergebnis;
            new Ausgabenformatierung(tmp);
        }
    }

    /**
     * Hilfsmethode, um aus den Daten einer queryResult (oder ähnlichem) einen String zu erzeugen.
     * @param attributes Die Spaltenüberschriften
     * @param result Die Tabelleninhalte
     * @return Tabellenähnlich formatierte Ausgabe
     */
    private String formatSQLOutput(String[] attributes, String[][] result){
        String formattedString = "";
        for(String attribute:attributes)
        {
            formattedString = formattedString + attribute + "; ";
        }
        formattedString = formattedString + "\n\n";
        for(String[] row:result){
            for(String entry:row){
                formattedString = formattedString + entry + "; ";
            }
            formattedString = formattedString + "\n";
        }
        return formattedString;
    }
    /**
     * Hilfsmethode für das Ausführen von SQL-Befehlen. Ruft intern formatSQLOutput auf.
     * @param statement Die auszuführende SQL-Anweisung
     * @return Verschiedene Ausgaben je nach Fall: 1) SQL-Abfrage: Tabellenähnlich formatiertes Ergebnis 2) SQL-Anweisung ohne Rückgabe: "Success" 3) Fehler etc.: Nähere Infos zum Fehler
     */
    public String processSQL(String statement) {
        if(dbController.isConnected()) {
            dbController.executeStatement(statement);
            QueryResult queryResult = dbController.getCurrentQueryResult();
            if(queryResult !=null) {
                return formatSQLOutput(queryResult.getColumnNames(), queryResult.getData());
            }else{
                String error = dbController.getErrorMessage();
                if(error !=null) {
                    return error;
                }else{
                    return "Success";
                }
            }
        }else{
            return "Connection not established.";
        }
    }

    public String getColumnName(){
        String[] attributes = dbController.getCurrentQueryResult().getColumnNames();
        String formattedString = "";
        for(String attribute:attributes) {
            formattedString = formattedString + attribute + "; ";
        }
        formattedString = formattedString + "\n\n";
        return formattedString;
    }

    private void loescheTabellen() {
        System.out.println("Löschen " + processSQL("SHOW TABLES LIKE 'JR_Kv_%'"));
        if(dbController.getCurrentQueryResult() != null && dbController.getCurrentQueryResult().getData().length>0){
            String[][] tmpAll= dbController.getCurrentQueryResult().getData();
            String tmpsql = "DROP TABLE " + tmpAll[0][0];
            for (int i = 1; i < tmpAll.length; i++) {
                tmpsql += ", " + tmpAll[i][0];
            }
            System.out.println("Löschenbefehl  " + tmpsql);
            processSQL("SET FOREIGN_KEY_CHECKS=0");
            processSQL(tmpsql);
            processSQL("SET FOREIGN_KEY_CHECKS=1");

        }
        System.out.println("Alte Tabellen und Datensätze vollständig entfernt");
    }

    private void erstelleTabellen(){
        System.out.println(processSQL("CREATE TABLE JR_Kv_Standorte(" +
                "ID INTEGER NOT NULL," +
                "Koordinate01 INTEGER," +
                "Koordinate02 INTEGER," +
                "Gesamtkampfkraft INTEGER," +
                "PRIMARY KEY(ID))" +
                ";"));


        System.out.println(processSQL("CREATE TABLE JR_Kv_Fahrzeuge(" +
                "ID INTEGER NOT NULL," +
                "Typ VARCHAR(20)," +
                "Baujahr INTEGER," +
                "Fahrzeugführer INTEGER," +
                "Stationsort INTEGER," +
                "zerstört BOOLEAN," +
                "Besatzung VARCHAR(10)," +
                "PRIMARY KEY(ID))" +
                ";"));


        System.out.println(processSQL("CREATE TABLE JR_Kv_Fahrzeugtypen(" +
                "Typ VARCHAR(10) NOT NULL," +
                "Fahrzeugart VARCHAR(20)," +
                "PS INTEGER," +
                "Besatzungszahl Integer," +
                "Kampfkraft INTEGER," +
                "PRIMARY KEY(Typ))" +
                ";"));


        System.out.println(processSQL("CREATE TABLE JR_Kv_Personen(" +
                "Erkennungsnummer INTEGER NOT NULL," +
                "Vorname VARCHAR(30)," +
                "Nachname VARCHAR(30)," +
                "Age INTEGER," +
                "Geschlecht VARCHAR(10)," +
                "Geburtstag VARCHAR(10)," +
                "Einheit INTEGER," +
                "ImDienst BOOLEAN," +
                "Tot BOOLEAN," +
                "Straße VARCHAR(40)," +
                "Hausnummer INTEGER," +
                "PLZ INTEGER," +
                "Stadt VARCHAR(20)," +
                "Land VARCHAR(30)," +
                "PRIMARY KEY(Erkennungsnummer))" +
                ";"));

        System.out.println(processSQL("CREATE TABLE JR_Kv_Einheit(" +
                "ID INTEGER NOT NULL," +
                "Truppstärke INTEGER," +
                "Oberbefehlshaber INTEGER," +
                "Erfahrungswert INTEGER," +
                "Kampfkraft INTEGER," +
                "ImEinsatz BOOLEAN," +
                "PRIMARY KEY(ID))" +
                ";"));

        System.out.println(processSQL("CREATE TABLE JR_Kv_Besatzung(" +
                "Spitzname VARCHAR(20) NOT NULL," +
                "Fahrzeug INTEGER," +
                "Erfahrung INTEGER," +
                "PRIMARY KEY(Spitzname))" +
                ";"));

        System.out.println(processSQL("CREATE TABLE JR_Kv_Feinde(" +
                "ID INTEGER NOT NULL," +
                "Name VARCHAR(20)," +
                "Kampfkraft INTEGER," +
                "PRIMARY KEY(ID))" +
                ";"));


        System.out.println(processSQL("CREATE TABLE JR_Kv_Kampfhandlung(" +
                "Codename VARCHAR(10) NOT NULL," +
                "Standort INTEGER," +
                "Beschreibung VARCHAR(100)," +
                "Opferzahl INTEGER," +
                "PRIMARY KEY(Codename))" +
                ";"));

        System.out.println(processSQL("CREATE TABLE JR_Kv_KämpfendeTruppe(" +
                "Codename VARCHAR(10) NOT NULL," +
                "Einheit INTEGER," +
                "PRIMARY KEY(Codename, Einheit))" +
                ";"));

        System.out.println(processSQL("CREATE TABLE JR_Kv_AngreifendeTruppe(" +
                "Codename VARCHAR(10) NOT NULL," +
                "Feind INTEGER," +
                "PRIMARY KEY(Codename, Feind))" +
                ";"));

        /*Die Fremdschlüssel definieren
         */
        System.out.println("Ab hier werden die Fremdschlüssel gesetzt");

        System.out.println(processSQL("ALTER TABLE JR_Kv_AngreifendeTruppe " +
                "ADD CONSTRAINT FOREIGN KEY (Codename) REFERENCES JR_Kv_Kampfhandlung (Codename), " +
                "ADD CONSTRAINT FOREIGN KEY (Feind) REFERENCES JR_Kv_Feinde (ID) " +
                ";"));

        System.out.println(processSQL("ALTER TABLE JR_Kv_KämpfendeTruppe " +
                "ADD CONSTRAINT FOREIGN KEY (Codename) REFERENCES JR_Kv_Kampfhandlung (Codename), " +
                "ADD CONSTRAINT FOREIGN KEY (Einheit) REFERENCES JR_Kv_Einheit (ID) " +
                ";"));

        System.out.println(processSQL("ALTER TABLE JR_Kv_Besatzung " +
                "ADD CONSTRAINT FOREIGN KEY (Fahrzeug) REFERENCES JR_Kv_Fahrzeuge (ID) " +
                ";"));

        System.out.println(processSQL("ALTER TABLE JR_Kv_Einheit " +
                "ADD CONSTRAINT eK FOREIGN KEY (Oberbefehlshaber) REFERENCES JR_Kv_Personen (Erkennungsnummer) " +
                ";"));


        System.out.println(processSQL("ALTER TABLE JR_Kv_Kampfhandlung " +
                "ADD CONSTRAINT FOREIGN KEY (Standort) REFERENCES JR_Kv_Standorte (ID) " +
                ";"));


        System.out.println(processSQL("ALTER TABLE JR_Kv_Personen " +
                "ADD CONSTRAINT pK FOREIGN KEY (Einheit) REFERENCES JR_Kv_Einheit (ID) " +
                ";"));

        System.out.println(processSQL("ALTER TABLE JR_Kv_Fahrzeuge " +
                "ADD CONSTRAINT FOREIGN KEY (Typ) REFERENCES JR_Kv_Fahrzeugtypen (Typ), " +
                "ADD CONSTRAINT FOREIGN KEY (Fahrzeugführer) REFERENCES JR_Kv_Personen (Erkennungsnummer), " +
                "ADD CONSTRAINT FOREIGN KEY (Stationsort) REFERENCES JR_Kv_Standorte (ID), " +
                "ADD CONSTRAINT FOREIGN KEY (Besatzung) REFERENCES JR_Kv_Besatzung (Spitzname) " +
                ";"));
    }
}
