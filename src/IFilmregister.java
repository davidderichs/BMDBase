import java.util.ArrayList;

/**
 * Created by David Derichs on 07.01.2018.
 */
public interface IFilmregister {

    public boolean add(String title);
    public ArrayList<Film> readAll();
    public Film readByID(int id);
    public Film readByTitleDE(String title);
    public Film readByTitelEN(String title);
    public boolean update();
    public boolean delete();
    public boolean updateTitleDE(String newTitle);
    public boolean updateTitleEN(String newTitle);
}