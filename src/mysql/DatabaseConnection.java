package mysql;
import java.sql.Connection;
import java.sql.DriverManager;
public class DatabaseConnection {
    String driver;
    String dbName;
    String connectionURL;
    String username;
    String password;
    public DatabaseConnection() {
        driver = "com.mysql.jdbc.Driver";
        connectionURL = "jdbc:mysql://localhost:3306/";
        dbName = "airlinesystem";
        username = "root";
        password = "mecanoball";
    }
    public Connection getConnection() throws Exception {
        Class.forName(driver);
        Connection connection = DriverManager.getConnection(connectionURL + dbName, username, password);
        return connection;
    }
}