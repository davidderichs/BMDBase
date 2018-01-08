import java.util.ArrayList;

/**
 * Created by David Derichs on 07.01.2018.
 */
public class Film {

    /*
	 * Klassenvariablen
	 */

    //Jahr der Veröffentlichung
    private static int jahr;
    // Länge des Films
    private static int laenge;
    // Alters begrenzung
    private static int fsk;
    // Deutscher Titel des Films
    private static String titelDE;
    //Englischer Titel des Films
    private static String titelEN;
    //Sprache des Films
    private static String sprache;
    // Wichtige Darsteller
    private static String besetzung;


    public Film(String nameDE, String nameEN, int jahr, int fsk, int laenge, String sprache,String besatzung)
    {
        titelDE = nameDE;
        titelEN = nameEN;
        this.jahr = jahr;
        this.laenge = laenge;
        this.sprache = sprache;
        this.besetzung = besatzung;
        this.fsk = fsk;
    }



    public boolean add(String title) {
        return false;
    }

    public ArrayList<Film> readAll() {
        return null;
    }

    public Film readByID(int id) {
        return null;
    }


    public Film readByTitleDE(String title) {
        return null;
    }


    public Film readByTitelEN(String title) {
        return null;
    }


    public boolean update() {
        return false;
    }


    public boolean delete() {
        return false;
    }


    public boolean updateTitleDE(String newTitle) {
        return false;
    }


    public boolean updateTitleEN(String newTitle) {
        return false;
    }
}
