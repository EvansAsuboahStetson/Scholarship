import java.sql.Connection;
import java.sql.DriverManager;

public class MyConnection {
    public static Connection getConnection() throws Exception {

            Class.forName("com.mysql.jdbc.Driver");
            Connection myconn = DriverManager.getConnection("jdbc:mysql://localhost:3306/scholar", "root", "SarahDufie1999$");
            System.out.println("Connection established successfully with the database server.");

            return myconn;


    }
}

