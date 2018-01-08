import java.util.ArrayList;

/**
 * Created by David Derichs on 07.01.2018.
 */
public interface IFilmregister {
    public Film readByID(int id);
    public Film readByTitleDE(String title);
    public Film readByTitelEN(String title);
    public boolean create();
    public boolean read();
    public ArrayList<Film> readAll();
    public boolean update();
    public boolean delete();
}
