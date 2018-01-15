import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by David on 08.01.2018.
 */
public class Filmregister implements IFilmregister {

    private DatabaseConnection connection;
    private ArrayList<Film> films;

    public Filmregister() throws FilmDatenException, SQLException, ClassNotFoundException {
        this.connection = new DatabaseConnection();
        this.films = this.connection.getAllFilms();
    }



    @Override
    public Film getFilmByID(int id) throws FilmDatenException, SQLException {
        return this.connection.getFilmByID(id);
    }

    @Override
    public Film getFilmByTitleDE(String title) throws FilmDatenException, SQLException {
        return this.connection.getFilmByTitleDE(title);
    }

    @Override
    public Film getFilmByTitelEN(String title) throws FilmDatenException, SQLException {
        if (title == null) {
        	throw new FilmDatenException();
        } 
        if (title.isEmpty()){
        	throw new FilmDatenException();
        }
    	return this.connection.getFilmByTitleEN(title);
    }

    @Override
    public ArrayList<Film> getAllFilms() throws FilmDatenException, SQLException {
        this.films = this.connection.getAllFilms();
        return this.films;
    }

    @Override
    public boolean saveFilm(Film film) throws FilmDatenException, SQLException {
        boolean addedToDatabase = this.connection.addFilm(film);
        if (addedToDatabase){
            this.films = this.connection.getAllFilms();
            return true;
        }
        return false;
    }

    @Override
    public boolean updateFilm(Film film) throws FilmDatenException, SQLException {
        return this.connection.updateFilm(film);
    }

    @Override
    public boolean deleteFilm(Film film) throws FilmDatenException, SQLException {
        return this.connection.removeFilm(film);
    }
    
    public boolean isFilmInDatabase(String titel) throws FilmDatenException, SQLException
    {
		for (Film film : this.getAllFilms()) {
			if (film.getTitelDE().equals(titel)) return true;
		}
    	return false;
    	
    }


}
