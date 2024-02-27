import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Menu {
    // ANSI escape codes for colors
    public static final  String ANSI_BRAWN = "\u001B[38;5;94m";
    public static final  String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static void main(String[] args) throws SQLException {
        int choice, cityId , historicalDataId ,temperature;
        LocalDate eventDate=null;
        String dateEvent;
        String cityName;
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("dd/MM/yyyy");
        float currentTemperature,currentHumidity,currentWindSpeed;
        do {
            System.out.println(ANSI_CYAN+"\t\t\t||==================================================================================================||");
            System.out.println("\t\t\t||---------------------------------|            Menu               |--------------------------------||");
            System.out.println("\t\t\t||==================================================================================================||"+ANSI_RESET);
            System.out.println(ANSI_GREEN+"\t\t\t||------------|   1: Add City                           |   6:  Add City History        |-----------||");
            System.out.println(ANSI_BLUE+"\t\t\t||------------|   2: Display All City                   |   7:  Display City History    |-----------||");
            System.out.println(ANSI_YELLOW+"\t\t\t||------------|   3: Update City                        |   8:  Update City History     |-----------||");
            System.out.println(ANSI_RED+"\t\t\t||------------|   4: Delete City                        |   9:  Delete City History     |-----------||");
            System.out.println("\t\t\t||------------|   5: Search and Display City Weather    |   10: Quitter application     |-----------||");
            System.out.println(ANSI_CYAN+"\t\t\t||==================================================================================================||"+ANSI_RESET);
            System.out.println(ANSI_BRAWN+"Enter votre choix: "+ANSI_RESET);
            choice = new Scanner(System.in).nextInt();
            switch (choice) {
                case 1:
                    System.out.print(ANSI_GREEN+" EntrerIdentifiant unique pour la ville :");
                    cityId= new Scanner(System.in).nextInt();
                    System.out.print(" Entrer Nom de la ville : ");
                    cityName = new Scanner(System.in).nextLine();
                    System.out.print("Température actuelle :");
                    currentTemperature = new Scanner(System.in).nextFloat();
                    System.out.print("Taux d'humidité actuelle :");
                    currentHumidity = new Scanner(System.in).nextFloat();
                    System.out.print("Vitesse du vent actuelle:");
                    currentWindSpeed = new Scanner(System.in).nextFloat();
                    Connection_DB.addCity(new City(cityId, cityName, currentTemperature,currentHumidity,currentWindSpeed));
                    break;
                case 2:
                    System.out.println(ANSI_BLUE+"All city:");
                   for (City city : Connection_DB.getAllCity()) {
                        System.out.println(city);
                    }
                    break;
                case 3:
                    System.out.print(ANSI_YELLOW+"Enter city ID to update :");
                    cityId = new Scanner(System.in).nextInt();
                    System.out.print("Nom de la ville : ");
                    cityName = new Scanner(System.in).nextLine();
                    System.out.print("Température actuelle  :");
                    currentTemperature = new Scanner(System.in).nextFloat();
                    System.out.print("Taux d'humidité actuelle :");
                    currentHumidity = new Scanner(System.in).nextFloat();
                    System.out.print("Vitesse du vent actuelle:");
                    currentWindSpeed = new Scanner(System.in).nextFloat();
                    Connection_DB.updateCity(new City(cityId, cityName, currentTemperature,currentHumidity,currentWindSpeed));
                    break;
                case 4:
                    System.out.print(ANSI_RED+"Enter City ID to delete: ");
                    cityId = new Scanner(System.in).nextInt();
                    Connection_DB.deleteCity(cityId);
                    break;
                case 5:
                   System.out.println(ANSI_BLUE+                                                                                                                                                                                                       "-----<Entrez Identifiant de la ville associée :");
                        cityName = new Scanner(System.in).nextLine();
                        Connection_DB.searchCityHistory(cityName);
                        break;
                case 6:
                    System.out.print(ANSI_GREEN+"Identifiant unique pour les données historiques :");
                    historicalDataId = new Scanner(System.in).nextInt();
                    System.out.print("Identifiant de la ville associée: ");
                    cityId = new Scanner(System.in).nextInt();
                    System.out.print("Date de l'événement météorologique historique :");
                    dateEvent = new Scanner(System.in).nextLine();
                    eventDate= LocalDate.parse(dateEvent,formatter);
                    System.out.print("Température historique :");
                    temperature = new Scanner(System.in).nextInt();
                    Connection_DB.addCityHistory(new CityHistory(historicalDataId, cityId, eventDate,temperature));

                    break;
                case 7:
                    System.out.println(ANSI_BLUE+"All city history:");
                    for (CityHistory cityh : Connection_DB.getAllCityHistory()) {
                        System.out.println(cityh);
                    }

                    break;
                case 8:
                    System.out.print(ANSI_YELLOW+"Enter city history ID to update :");
                    historicalDataId = new Scanner(System.in).nextInt();
                    System.out.print("id de la ville : ");
                    cityId = new Scanner(System.in).nextInt();
                    System.out.print("Date de l'événement météorologique historique (dd/MM/yyyy) :");
                    dateEvent = new Scanner(System.in).nextLine();
                    eventDate= LocalDate.parse(dateEvent,formatter);
                    System.out.print("Température historique :");
                    temperature = new Scanner(System.in).nextInt();
                    Connection_DB.updateCityHistory(new CityHistory(historicalDataId, cityId, eventDate,temperature));
                    break;
                case 9:
                    System.out.print(ANSI_RED+"Enter City History ID to delete: ");
                    historicalDataId = new Scanner(System.in).nextInt();
                    Connection_DB.deleteCityHistory(historicalDataId);
                    break;
                case 10:
                    System.out.println(" Quitté  ");
                    break;
                default: System.out.println("      Entrez un choix valid !       ");
                    break;
            }
        }while (choice != 11) ;
    }
}