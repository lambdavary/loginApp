import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseClass {

    public static Connection getConnection(){
        Connection connection = null;
        String password = "enter your password here";
        try {
            Class.forName("com.mysql.jdbc.Driver");

            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/user_db?useSSL=false", "root", password);
        }catch (Exception e){
            e.printStackTrace();
        }

        return connection;
    }
}
