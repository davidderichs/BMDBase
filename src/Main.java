
/**
 * Created by David Derichs on 07.01.2018.
 */
public class Main {
    public static void main(String[] args){
        DatabaseConnection connection = new DatabaseConnection();
        try {
            connection.readDataBase();
        } catch (Exception e){
            System.out.println(e);
        }
    }
}
