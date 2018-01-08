import java.sql.*;
import java.util.ArrayList;

/**
 * Created by David Derichs on 07.01.2018.
 */

public class DatabaseConnection {
    private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    DatabaseConnection () throws Exception {
        // This will load the MySQL driver, each DB has its own driver
        Class.forName("com.mysql.jdbc.Driver");
        // Setup the connection with the DB
        this.connect = DriverManager
                .getConnection("jdbc:mysql://localhost/bmdbase?"
                        + "user=root");
    }

    public void getFilmByID(int id) throws SQLException {
        // Statements allow to issue SQL queries to the database
        statement = connect.createStatement();
    }

    public void getFilmByTitleDE(String title) throws SQLException{
        // Statements allow to issue SQL queries to the database
        statement = connect.createStatement();
    }

    public void getFilmByTitleEN(String title) throws SQLException{
        // Statements allow to issue SQL queries to the database
        statement = connect.createStatement();
    }

    public void addFilmToDatabase(Film film) throws SQLException{
        // Statements allow to issue SQL queries to the database
        statement = connect.createStatement();
    }

    public ArrayList<Film> getAllFilmsFromDatabse() throws Exception{
        // Statements allow to issue SQL queries to the database
        statement = connect.createStatement();
        // Result set get the result of the SQL query
        resultSet = statement
                .executeQuery("select * from bmdbase.bmdbase");
//        writeMetaData(resultSet);
//        writeResultSet(resultSet);
        return convertToJavaObjectList(resultSet);
    }

    private ArrayList<Film> convertToJavaObjectList(ResultSet resultSet) throws Exception{
        ArrayList<Film> filmList = new ArrayList<Film>();
        while (resultSet.next()) {
            // It is possible to get the columns via name
            // also possible to get the columns via the column number
            // which starts at 1
            // e.g. resultSet.getSTring(2);
            String id = resultSet.getString("id");
            String titel = resultSet.getString("titel");
            String title = resultSet.getString("title");
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
            filmList.add(
                    // public Film(String nameDE, String nameEN, int jahr, int fsk, int laenge, String sprache,String besatzung
                    new Film(titel, title, (int) date.getYear(), fsk, laenge, sprache, schauspieler)
            );
        }
        return filmList;
    }

    public void updateFilmOnDatabase(Film film) throws SQLException{
        // Statements allow to issue SQL queries to the database
        statement = connect.createStatement();
    }

    public void removeFilmFromDatabase(Film film) throws SQLException{
        // Statements allow to issue SQL queries to the database
        statement = connect.createStatement();
    }

    private void writeMetaData(ResultSet resultSet) throws SQLException {
        //  Now get some metadata from the database
        // Result set get the result of the SQL query
        System.out.println("The columns in the table are: ");
        System.out.println("Table: " + resultSet.getMetaData().getTableName(1));
        for  (int i = 1; i<= resultSet.getMetaData().getColumnCount(); i++){
            System.out.println("Column " +i  + " "+ resultSet.getMetaData().getColumnName(i));
        }
    }

    private void writeResultSet(ResultSet resultSet) throws SQLException {
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

    // You need to close the resultSet
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
     * BeispielFunktion
     */
//    public void readDataBase() throws Exception {
//        try {
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
//            writeResultSet(resultSet);
//
//            // Remove again the insert comment
//            preparedStatement = connect
//                    .prepareStatement("delete from feedback.comments where myuser= ? ; ");
//            preparedStatement.setString(1, "Test");
//            preparedStatement.executeUpdate();
//
//            resultSet = statement
//                    .executeQuery("select * from feedback.comments");
//            writeMetaData(resultSet);
//
//        } catch (Exception e) {
//            throw e;
//        } finally {
//            close();
//        }
//
//    }



}
