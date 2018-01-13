import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by David Derichs on 07.01.2018.
 */
public interface IFilmregister {
    public Film getFilmByID(int id) throws FilmDatenException, SQLException;
    public Film getFilmByTitleDE(String title) throws FilmDatenException, SQLException;
    public Film getFilmByTitelEN(String title) throws FilmDatenException, SQLException;
    public ArrayList<Film> getAllFilms() throws Exception;
    public boolean saveFilm(Film film) throws Exception;
    public boolean updateFilm(Film film) throws FilmDatenException, SQLException;
    public boolean deleteFilm(Film film) throws FilmDatenException, SQLException;
}
