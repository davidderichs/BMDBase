import com.mysql.jdbc.exceptions.jdbc4.CommunicationsException;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * Created by David Derichs on 07.01.2018.
 * Datenbank-Klasse, die Datenbank-Methoden für das Film-Register bereitstellt.
 */

public class DatabaseConnection {

    // SQL-Connection Object zur Kommunikation mit dem Server
    private Connection connect = null;
    // SQL-Statement, das mittels des Connection-Objects an den Server verschickt wird.
    private Statement statement = null;
    // Kann zum Erstellen von größeren Statements verwendet werden. Hier ungenutzt.
    private PreparedStatement preparedStatement = null;
    // Daten, die z.B. nach einer versendeten Query (Statement) vom Server als Antwort zurückkommen
    // Üblicherweise Daten, die von einer Select-Abfrage kommen.
    private ResultSet resultSet = null;

    /***
     * Datenbank Verbindung aufnehmen.
     * Dazu wird der JDBC-Treiber für MySQL genutzt.
     * Über den Driver-Manager wird eine Connection mit URL und User-Informationen aufgebaut
     * und im Connection-Object gespeichert.
     * @throws SQLException
     * @throws CommunicationsException
     * @throws ClassNotFoundException
     */
    DatabaseConnection () throws SQLException, CommunicationsException, ClassNotFoundException {
        // This will load the MySQL driver, each DB has its own driver
        Class.forName("com.mysql.jdbc.Driver");
        // Setup the connection with the DB
        this.connect = DriverManager.getConnection("jdbc:mysql://localhost/bmdbase?" + "user=root");
    }

    /**
     * Fügt per Insert-Statement einen Datensatz in die Datenbank ein.
     * Die Daten nimmt die Methode aus einem übergebenen Film-Objekt.
     * Die einzelnen Attribute werden in String-Variablen übersetzt und dann dem Statement zugewiesen.
     * @param film Film-Java-Objekt, welches die Daten für das Statement enthält.
     * @return War das Statement erfolgreich, gibt die Methode true zurück.
     * @throws SQLException
     */
    public boolean addFilm(Film film) throws SQLException{
        statement = connect.createStatement();
        String statementStart = "insert into  bmdbase.bmdbase (titel, title, schauspieler, fsk, sprache, laenge, date) ";
        String titel =  "'"+film.getTitelDE()+"'";
        String title =  "'"+film.getTitelEN()+"'";
        String schauspieler = "'"+film.getDarsteller()+"'";
        String fsk =  "'"+Integer.toString(film.getFsk())+"'";
        String sprache =  "'"+film.getSprache()+"'";
        String laenge =  "'"+Integer.toString(film.getLaenge())+"'";
        String date =  "'"+Integer.toString(film.getJahr())+"-01-01"+"'";
        String statementEnd = "VALUES ("
                +titel+", "
                +title+", "
                +schauspieler+", "
                +fsk+", "
                +sprache+", "
                +laenge+", "
                +date
                +")";
        return (statement.executeUpdate(statementStart+statementEnd+";")==1);
    }

    /**
     * Ändert bzw. Updated einen Datensatz in der Datenbank.
     * Die Daten nimmt die Methode aus einem übergebenen Film-Objekt.
     * Die einzelnen Attribute werden in String-Variablen übersetzt und dann dem Statement zugewiesen.
     * @param film Film-Java-Objekt, welches die Daten für das Statement enthält.
     * @return War das Statement erfolgreich, gibt die Methode true zurück.
     * @throws SQLException
     */
    public boolean updateFilm(Film film) throws SQLException{
        statement = connect.createStatement();
        String titel =  "'"+film.getTitelDE()+"'";
        String title =  "'"+film.getTitelEN()+"'";
        String schauspieler = "'"+film.getDarsteller()+"'";
        String fsk =  "'"+Integer.toString(film.getFsk())+"'";
        String sprache =  "'"+film.getSprache()+"'";
        String laenge =  "'"+Integer.toString(film.getLaenge())+"'";
        String date =  "'"+Integer.toString(film.getJahr())+"-01-01"+"'";
        String statementStart = "UPDATE bmdbase.bmdbase SET titel= "+titel+", title="+title+", schauspieler="+schauspieler+", fsk="+fsk+", sprache="+sprache+", laenge="+laenge+", date="+date;
        String statementEnd = "WHERE id = "+film.getID();
        return (statement.executeUpdate(statementStart+statementEnd+";")==1);
    }

    /**
     * Löscht einen Datensatz in der Datenbank.
     * Dazu wird die ID des Java-Film-Objektes genutzt, welche der ID in der Datenbank entspricht.
     * Ist diese Information nicht verfügbar, wird der Deutsche Titel zum Löschen genutzt.
     * Ist dieser ebenfalls nicht verfügbar, wird der Entlische Titel zum Löschen genutzt.
     * @param film Film-Objekt, welches aus der Datenbank gelöscht werden soll.
     * @return Liefert true, wenn der Datensatz erfolgreich gelöscht wurde.
     * @throws SQLException
     */
    public boolean removeFilm(Film film) throws SQLException{
        // Statements allow to issue SQL queries to the database
        statement = connect.createStatement();
        System.out.println(film.getID());
        if (film.getID()>0){
            return removeFilmByID(film.getID());
        } if (film.getTitelDE().length()>0){
            return removeFilmByTitleDE(film.getTitelDE());
        } if (film.getTitelEN().length()>0){
            return removeFilmByTitleEN(film.getTitelEN());
        }
        return false;
    }

    /**
     * Hilfsmethode, die einen Film anhand der ID aus der Datenbank löscht.
     * @param id ID das Java-Film-Objektes und des Datensatzes.
     * @return Liefert true, wenn Datensatz erfolgreich gelöscht wurde.
     * @throws SQLException
     */
    public boolean removeFilmByID(int id) throws SQLException{
        statement = connect.createStatement();
        String statementStart = "DELETE FROM bmdbase.bmdbase WHERE id= '"+id+"' ;";
        System.out.println(statementStart);
        return (statement.executeUpdate(statementStart)==1);
    }

    /**
     * Hilfsmethode, die einen Film anhand des Deutschen Titels aus der Datenbank löscht.
     * @param title Deutscher Titel des Java-Film-Objektes und des Datensatzes.
     * @return Liefert true, wenn Datensatz erfolgreich gelöscht wurde.
     * @throws SQLException
     */
    public boolean removeFilmByTitleDE(String title) throws SQLException{
        statement = connect.createStatement();
        String statementStart = "DELETE FROM bmdbase.bmdbase WHERE titel= '"+title+"' ;";
        System.out.println(statementStart);
        return (statement.executeUpdate(statementStart)==1);
    }

    /**
     * Hilfsmethode, die einen Film anhand des Englischen Titels aus der Datenbank löscht.
     * @param title Englischer Titel des Java-Film-Objektes und des Datensatzes.
     * @return Liefert true, wenn Datensatz erfolgreich gelöscht wurde.
     * @throws SQLException
     */
    public boolean removeFilmByTitleEN(String title) throws SQLException{
        statement = connect.createStatement();
        String statementStart = "DELETE FROM bmdbase.bmdbase WHERE title= '"+title+"' ;";
        return (statement.executeUpdate(statementStart)==1);
    }

    /**
     * Sucht anhand einer ID in der Datenbank nach einem Datensatz.
     * Liefert ein Java-Objekt vom Typ Film zurück, falls dieser gefunden wurde.
     * Zum Umwandeln des resultSets in ein Java-Objekt wird eine Hilfsmethode verwendet.
     * @param id ID des Film-Objekts
     * @return Film-Objekt, welches zuvor aus der Datenbank ausgelesen und in ein Java-Objekt umgewandelt wurde.
     * @throws SQLException
     * @throws FilmDatenException
     */
    public Film getFilmByID(int id) throws SQLException, FilmDatenException {
        statement = connect.createStatement();
        resultSet = statement.executeQuery("select * from bmdbase.bmdbase where id = " + id + ";");
        return convertToJavaObject(resultSet);
    }

    /**
     * Sucht anhand des Deutschen Titels in der Datenbank nach einem Datensatz.
     * Liefert ein Java-Objekt vom Typ Film zurück, falls dieser gefunden wurde.
     * Zum Umwandeln des resultSets in ein Java-Objekt wird eine Hilfsmethode verwendet.
     * @param titel Deutscher Titel des Film-Objekts
     * @return Film-Objekt, welches zuvor aus der Datenbank ausgelesen und in ein Java-Objekt umgewandelt wurde.
     * @throws SQLException
     * @throws FilmDatenException
     */
    public Film getFilmByTitleDE(String titel) throws SQLException, FilmDatenException {
        // Statements allow to issue SQL queries to the database
        statement = connect.createStatement();
        resultSet = statement.executeQuery("select * from bmdbase.bmdbase where titel = '" + titel + "';");
        return convertToJavaObject(resultSet);
    }

    /**
     * Sucht anhand des Englischen Titels in der Datenbank nach einem Datensatz.
     * Liefert ein Java-Objekt vom Typ Film zurück, falls dieser gefunden wurde.
     * Zum Umwandeln des resultSets in ein Java-Objekt wird eine Hilfsmethode verwendet.
     * @param title Englischer Titel des Film-Objekts
     * @return Film-Objekt, welches zuvor aus der Datenbank ausgelesen und in ein Java-Objekt umgewandelt wurde.
     * @throws SQLException
     * @throws FilmDatenException
     */
    public Film getFilmByTitleEN(String title) throws SQLException, FilmDatenException {
        // Statements allow to issue SQL queries to the database
        statement = connect.createStatement();
        resultSet = statement.executeQuery("select * from bmdbase.bmdbase where title = '" + title + "';");
        return convertToJavaObject(resultSet);
    }

    /**
     * Liefert alle Filme, die sich in der Datenbank befinden als Liste von Java-Objekten vom Typ Film aus.
     * Zum Umwandeln des resultSets in ein Java-Objekt wird eine Hilfsmethode verwendet.
     * @return List von Objekte des Typs Film
     * @throws SQLException
     * @throws FilmDatenException
     */
    public ArrayList<Film> getAllFilms() throws SQLException, FilmDatenException {
        // Statements allow to issue SQL queries to the database
        statement = connect.createStatement();
        // Result set get the result of the SQL query
        resultSet = statement.executeQuery("select * from bmdbase.bmdbase");
        return convertToJavaObjectList(resultSet);
    }

    /**
     * Hilfsmethode, um ein ResultSet aus der Datenbank in ein Java-Objekt vom Typ Film zu erzeugen.
     * @param resultSet ResultSet, dass Informationen vom SQL-Server beinhaltet, z.B. nach einer SELECT-Abfrage.
     * @return Java-Objekt vom Typ Film
     * @throws SQLException
     * @throws FilmDatenException
     */
    private Film convertToJavaObject(ResultSet resultSet) throws SQLException, FilmDatenException {
            // It is possible to get the columns via name
            // also possible to get the columns via the column number
            // which starts at 1
            // e.g. resultSet.getSTring(2);
            resultSet.next();
            String id = resultSet.getString("id");
            String titelDE = resultSet.getString("titel");
            String titleEN = resultSet.getString("title");
            String regie = resultSet.getString("regie");
            String genre = resultSet.getString("genre");
            String schauspieler = resultSet.getString("schauspieler");
            String produzent = resultSet.getString("produzent");
            String studio = resultSet.getString("studio");
            int fsk = resultSet.getInt("fsk");
            String sprache = resultSet.getString("sprache");
            int laenge = resultSet.getInt("laenge");
            Date date = resultSet.getDate("date");
            String land = resultSet.getString("land");
            boolean farbe = resultSet.getBoolean("farbe");
            int bewertung = resultSet.getInt("bewertung");

            return new Film(titelDE, titleEN, Integer.parseInt(getYearFromDate(date)), fsk, laenge, sprache, schauspieler);
    }

    /**
     * Wandelt ein ResultSet, welches mehrere Datensätze beinhaltet in eine Liste von Java-Objekte des Typs Film um.
     * @param resultSet
     * @return Liste von Film-Objekten.
     * @throws SQLException
     * @throws FilmDatenException
     */
    private ArrayList<Film> convertToJavaObjectList(ResultSet resultSet) throws SQLException, FilmDatenException {
        ArrayList<Film> filmList = new ArrayList<Film>();
        while (resultSet.next()) {
            String id = resultSet.getString("id");
            String titelDE = resultSet.getString("titel");
            String titleEN = resultSet.getString("title");
            String regie = resultSet.getString("regie");
            String genre = resultSet.getString("genre");
            String schauspieler = resultSet.getString("schauspieler");
            String produzent = resultSet.getString("produzent");
            String studio = resultSet.getString("studio");
            int fsk = resultSet.getInt("fsk");
            String sprache = resultSet.getString("sprache");
            int laenge = resultSet.getInt("laenge");
            String land = resultSet.getString("land");
            boolean farbe = resultSet.getBoolean("farbe");
            int bewertung = resultSet.getInt("bewertung");

            Date date = resultSet.getDate("date");
            int year = Integer.parseInt(getYearFromDate(date));

            Film film = new Film(titelDE, titleEN, year, fsk, laenge, sprache, schauspieler);
            filmList.add( film );
        }
        return filmList;
    }

    /**
     * Hilfs-Methode, um nur das Jahr aus einem Objekt vom Typ Date zu erhalten.
     * @param date Date-Objekt
     * @return String, der das Jahr beinhaltet
     */
    private String getYearFromDate(Date date){
        SimpleDateFormat formatNowYear = new SimpleDateFormat("yyyy");
        return formatNowYear.format(date);
    }

    /**
     * Konsolenausgabe. Wird genutzt, um Antworten vom SQL-Server zu überprüfen oder einfach auf dern Konsole auszugeben.
     * Kann z.B. bei JUnit-Tests genutzt werden.
     * @param resultSet ResultSet vom Server
     * @throws SQLException
     */
    private void printDatabaseInformation(ResultSet resultSet) throws SQLException {
        //  Now get some metadata from the database
        // Result set get the result of the SQL query
        System.out.println("The columns in the table are: ");
        System.out.println("Table: " + resultSet.getMetaData().getTableName(1));
        for  (int i = 1; i<= resultSet.getMetaData().getColumnCount(); i++){
            System.out.println("Column " +i  + " "+ resultSet.getMetaData().getColumnName(i));
        }
    }

    /**
     * Konsolenausgabe. Wird genutzt, um Antworten vom SQL-Server zu überprüfen oder einfach auf dern Konsole auszugeben.
     * Kann z.B. bei JUnit-Tests genutzt werden.
     * @param resultSet ResultSet vom Server
     * @throws SQLException
     */
    private void printDatasetInformation(ResultSet resultSet) throws SQLException {
        // ResultSet is initially before the first data set
        while (resultSet.next()) {
            // It is possible to get the columns via name
            // also possible to get the columns via the column number
            // which starts at 1
            // e.g. resultSet.getSTring(2);
            String id = resultSet.getString("id");
            String titel = resultSet.getString("title");
            String regie = resultSet.getString("regie");
            String genre = resultSet.getString("genre");
            Date date = resultSet.getDate("date");
            System.out.println("id: " + id);
            System.out.println("titel: " + titel);
            System.out.println("regie: " + regie);
            System.out.println("genre: " + genre);
            System.out.println("date: " + date);
        }
    }

    /**
     * Methode, zum Schließen einer SQL-Verbindung.
     * Sehr wichtig !!!
     */
    public void close() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }

            if (statement != null) {
                statement.close();
            }

            if (connect != null) {
                connect.close();
            }
        } catch (Exception e) {

        }
    }

    /**
     * BeispielFunktionen
     */
//            // PreparedStatements can use variables and are more efficient
//            preparedStatement = connect
//                    .prepareStatement("insert into  feedback.comments values (default, ?, ?, ?, ? , ?, ?)");
//            // "myuser, webpage, datum, summary, COMMENTS from feedback.comments");
//            // Parameters start with 1
//            preparedStatement.setString(1, "Test");
//            preparedStatement.setString(2, "TestEmail");
//            preparedStatement.setString(3, "TestWebpage");
//            preparedStatement.setDate(4, new java.sql.Date(2009, 12, 11));
//            preparedStatement.setString(5, "TestSummary");
//            preparedStatement.setString(6, "TestComment");
//            preparedStatement.executeUpdate();
//
//            preparedStatement = connect
//                    .prepareStatement("SELECT myuser, webpage, datum, summary, COMMENTS from feedback.comments");
//            resultSet = preparedStatement.executeQuery();
//            printDatasetInformation(resultSet);
//
//            // Remove again the insert comment
//            preparedStatement = connect
//                    .prepareStatement("delete from feedback.comments where myuser= ? ; ");
//            preparedStatement.setString(1, "Test");
//            preparedStatement.executeUpdate();
//
//            resultSet = statement
//                    .executeQuery("select * from feedback.comments");
//            printDatabaseInformation(resultSet);
//            close();

}
