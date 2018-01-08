import java.util.ArrayList;

/**
 * Created by David Derichs on 07.01.2018.
 */
public class Main {
    public static void main(String[] args){
        DatabaseConnection connection = null;
        try {
            connection = new DatabaseConnection();
            ArrayList<Film> list = connection.getAllFilmsFromDatabse();
            System.out.println(list);
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
