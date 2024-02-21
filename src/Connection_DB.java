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

    // ---------------  Display All----------
    public static List<City> getAllCity() throws SQLException {
        List<City> citys = new ArrayList<>();
        String sql = "SELECT * FROM city";
        Connection connection = getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            int cityId = resultSet.getInt("cityId");
            String cityName = resultSet.getString("cityName");
            Float currentTemperature = resultSet.getFloat("currentTemperature");
            Float  currentHumidity = resultSet.getFloat("currentHumidity");
            Float  currentWindSpeed = resultSet.getFloat("currentWindSpeed");

            citys.add(new City(cityId, cityName, currentTemperature,currentHumidity,currentWindSpeed));
        }
        connection.close();
        statement.close();
        resultSet.close();
        return citys;
    }

    // ------------Update City -----------

    public static void updateCity(City city) throws SQLException {
        String sql = "UPDATE city SET cityId= ?,cityName=?,currentTemperature=?,currentHumidity=?,currentWindSpeed=? WHERE cityId=?";
        Connection connection = getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, city.getCityId());
        statement.setString(2, city.getCityName());
        statement.setFloat(3,city.getCurrentTemperature());
        statement.setFloat(4,city.getCurrentHumidity());
        statement.setFloat(5,city.getCurrentWindSpeed());
        statement.setInt(6, city.getCityId());
        statement.executeUpdate();
        connection.close();
        statement.close();
        System.out.println("City updated successfully!");
    }

    // ------------ Delete City ------------------
    public static void deleteCity(int cityId) throws SQLException {
        String sql = "DELETE FROM city WHERE cityId = ?";
        Connection connection = getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, cityId);
        statement.executeUpdate();
        connection.close();
        statement.close();
        System.out.println("City deleted successfully!");
    }

}
