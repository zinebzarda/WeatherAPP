import java.sql.SQLException;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) throws SQLException {
        int choice, cityId;
        String cityName;
        float currentTemperature,currentHumidity,currentWindSpeed;
        do {
            System.out.println("\t\t\t||======================================================================||");
            System.out.println("\t\t\t||------------|              Menu                           |-----------||");
            System.out.println("\t\t\t||======================================================================||");
            System.out.println("\t\t\t||------------|   1: Add City                            |-----------||");
            System.out.println("\t\t\t||------------|   2: Display All City                        |-----------||");
            System.out.println("\t\t\t||------------|   3: Update City                      |-----------||");
            System.out.println("\t\t\t||------------|   4: Delete City                  |-----------||");
            System.out.println("\t\t\t||------------|   5: Quitter application                    |-----------||");
            System.out.println("\t\t\t||======================================================================||");
            System.out.println("Enter votre choix: ");
            choice = new Scanner(System.in).nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Identifiant unique pour la ville :");
                    cityId= new Scanner(System.in).nextInt();
                    System.out.print("Nom de la ville : ");
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
                    System.out.println("All city:");
                   for (City city : Connection_DB.getAllCity()) {
                        System.out.println(city);
                    }
                    break;
                case 3:
                    System.out.print("Enter city ID to update :");
                    cityId = new Scanner(System.in).nextInt();
                    System.out.print("Nom de la ville : ");
                    cityName = new Scanner(System.in).nextLine();
                    System.out.print("Identifiant unique pour la ville :");
                    currentTemperature = new Scanner(System.in).nextFloat();
                    System.out.print("Taux d'humidité actuelle :");
                    currentHumidity = new Scanner(System.in).nextFloat();
                    System.out.print("Vitesse du vent actuelle:");
                    currentWindSpeed = new Scanner(System.in).nextFloat();
                    Connection_DB.updateCity(new City(cityId, cityName, currentTemperature,currentHumidity,currentWindSpeed));
                    break;
                case 4:
                    System.out.print("Enter City ID to delete: ");
                    cityId = new Scanner(System.in).nextInt();
                    Connection_DB.deleteCity(cityId);
                    break;
            }
        }while (choice != 5) ;
    }
}