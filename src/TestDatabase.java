/**
 * Created by David Derichs on 08.01.2018.
 */
public class TestDatabase {
    public static void main (String[]args){

        // TEST für die Datenbank
        DatabaseConnection connection = null;
        try {
            connection = new DatabaseConnection();
            System.out.println(connection.getAllFilms());
            connection.close();
        } catch (Exception e) {
            System.out.println("Fehler mit der Datenbank:");
            e.printStackTrace();
        }
    }
}
