import java.util.ArrayList;

/**
 * Created by David Derichs on 07.01.2018.
 */
public class Film implements IFilmregister{

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


    @Override
    public boolean add(String title) {
        return false;
    }

    @Override
    public ArrayList<Film> readAll() {
        return null;
    }

    @Override
    public Film readByID(int id) {
        return null;
    }

    @Override
    public Film readByTitleDE(String title) {
        return null;
    }

    @Override
    public Film readByTitelEN(String title) {
        return null;
    }

    @Override
    public boolean update() {
        return false;
    }

    @Override
    public boolean delete() {
        return false;
    }

    @Override
    public boolean updateTitleDE(String newTitle) {
        return false;
    }

    @Override
    public boolean updateTitleEN(String newTitle) {
        return false;
    }
}
