import java.sql.*;
public class Connection_DB {
    static final String URL = "jdbc:mysql://localhost:3306/weatherapp?serverTimezone=UTC";
    static final String USER = "Zarda";
    static final String PASSWORD = "1234";

    public static Connection getConnection() throws SQLException {

        return DriverManager.getConnection(URL, USER, PASSWORD);

    }
}
