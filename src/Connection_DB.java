import java.sql.*;
import java.util.*;
public class Connection_DB {
    static final String URL = "jdbc:mysql://localhost:3306/weatherapp?serverTimezone=UTC";
    static final String USER = "Zarda";
    static final String PASSWORD = "1234";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // +++++++++++++++++++++++++++++++City++++++++++++++++++++++++++
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

    // ++++++++++++++++++++++++ CityHistory+++++++++++++++

    //----------------- Add CityHistory------------
    public static void addCityHistory(CityHistory cityH) throws SQLException {
        String sql = "INSERT INTO cityhistory (historicalDataId, cityId, eventDate, temperature) " +
                "  VALUES (?,?,?,?)";
        Connection connection = getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, cityH.getHistoricalDataId());
        statement.setInt(2, cityH.getCityId());
        statement.setString(3, cityH.getEventDate());
        statement.setInt(4,cityH.getTemperature());
        statement.executeUpdate();
        connection.close();
        statement.close();
        System.out.println("City history add successfully!");
    }


    //----------------- Display CityHistory------------

    public static List<CityHistory> getAllCityHistory() throws SQLException {
        List<CityHistory> cityhs = new ArrayList<>();
        String sql = "SELECT * FROM cityhistory";
        Connection connection = getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            int historicalDataId = resultSet.getInt("historicalDataId");
            int cityId = resultSet.getInt("cityId");
            String eventDate = resultSet.getString("eventDate");
            int  temperature = resultSet.getInt("temperature");

            cityhs.add(new CityHistory(historicalDataId, cityId, eventDate,temperature));
        }
        connection.close();
        statement.close();
        resultSet.close();
        return cityhs;
    }

    // ------------Update City History-----------

    public static void updateCityHistory(CityHistory cityh) throws SQLException {
        String sql = "UPDATE cityhistory SET cityId=?, eventDate=?, temperature=? WHERE historicalDataId=?";
        Connection connection = getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, cityh.getCityId());
        statement.setString(2, cityh.getEventDate());
        statement.setInt(3, cityh.getTemperature());
        statement.setInt(4, cityh.getHistoricalDataId());
        statement.executeUpdate();
        connection.close();
        statement.close();
        System.out.println("City history updated successfully!");
    }

    // ------------ Delete City History ------------------
    public static void deleteCityHistory(int historicalDataId) throws SQLException {
        String sql = "DELETE FROM cityhistory WHERE historicalDataId = ?";
        Connection connection = getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, historicalDataId);
        statement.executeUpdate();
        connection.close();
        statement.close();
        System.out.println("City history deleted successfully!");
    }

    //----------------- Search by cityName-----------------
    public static City getCityByName(String cityName) throws SQLException {
        String sql = "SELECT * FROM city WHERE cityName = ?";
        Connection connection = getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, cityName);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            int cityId = resultSet.getInt("cityId");
            float currentTemperature = resultSet.getFloat("currentTemperature");
            float currentHumidity = resultSet.getFloat("currentHumidity");
            float currentWindSpeed = resultSet.getFloat("currentWindSpeed");
            return new City(cityId, cityName, currentTemperature, currentHumidity, currentWindSpeed);
        } else {
            return null;
        }
    }


}
