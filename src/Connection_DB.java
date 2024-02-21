import java.sql.*;
import java.util.*;
public class Connection_DB {
    static final String URL = "jdbc:mysql://localhost:3306/weatherapp?serverTimezone=UTC";
    static final String USER = "Zarda";
    static final String PASSWORD = "1234";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // ----------AddCity--------

    public static void addCity(City city) throws SQLException {
        String sql = "INSERT INTO city (cityId, cityName, currentTemperature, currentHumidity, currentWindSpeed)" +
               "  VALUES (?,?,?,?,?)";
        Connection connection = getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, city.getCityId());
        statement.setString(2, city.getCityName());
        statement.setFloat(3,city.getCurrentTemperature());
        statement.setFloat(4,city.getCurrentHumidity());
        statement.setFloat(5,city.getCurrentWindSpeed());
        statement.executeUpdate();
        connection.close();
        statement.close();
        System.out.println("City add successfully!");
    }



    // ------------Update City -----------

}
