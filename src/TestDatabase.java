/**
 * Created by David Derichs on 08.01.2018.
 */
public class TestDatabase {

    public static void testInsert() throws Exception {
        DatabaseConnection connection = new DatabaseConnection();
        Film film = new Film("DeutscherTitel", "TESTMovie", 2018, 18, 140, "deutsch", "Russel Crowe");
        System.out.print("Adding film: "+film.getTitelDE());
        connection.addFilm(film);
        connection.close();
    }

    public static void testUpdate() throws Exception {
//        DatabaseConnection connection = new DatabaseConnection();
//        Film film = new Film(2,"NeuerTitelaufDeutsch", "AnotherMovieTitle", 2018, 18, 140, "deutsch", "Johnny Depp");
//        System.out.print("Updating film: "+film.getTitelDE());
//        connection.updateFilm(film);
//        connection.close();
    }

    public static void testDeletion() throws Exception {
        DatabaseConnection connection = new DatabaseConnection();
        Film film = new Film("", "TESTMovie", 2018, 18, 140, "deutsch", "Russel Crowe");
        System.out.print("Updating film: "+film.getTitelDE());
        connection.removeFilm(film);
        connection.close();
    }

    public static void testGetByID() throws Exception {
        DatabaseConnection connection = new DatabaseConnection();
        Film film = connection.getFilmByID(1);
        System.out.println(film);
        connection.close();
    }

    public static void testGetFilmByTitleDE() throws Exception {
        DatabaseConnection connection = new DatabaseConnection();
        Film film = connection.getFilmByTitleDE("Gladiator");
        System.out.println(film);
        connection.close();
    }

    public static void testGetFilmByTitleEN() throws Exception {
        DatabaseConnection connection = new DatabaseConnection();
        Film film = connection.getFilmByTitleEN("Gladiator");
        System.out.println(film);
        connection.close();
    }

    public static void main (String[]args){

        // TEST für die Datenbank
        DatabaseConnection connection = null;
        try {
//            TestDatabase.testInsert();
//            TestDatabase.testDeletion();
//            TestDatabase.testGetFilmByTitleDE();
            TestDatabase.testGetFilmByTitleEN();
        } catch (Exception e) {
            System.out.println("Fehler mit der Datenbank:");
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
