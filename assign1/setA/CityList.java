import java.util.ArrayList;
import java.util.Scanner;

public class CityList {
   public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);

       System.out.print("Enter the number of cities: ");
       int n = scanner.nextInt();

       ArrayList<String> cities = new ArrayList<>();

       System.out.println("Enter the names of " + n + " cities:");
       for (int i = 0; i < n; i++) {
           cities.add(scanner.next());
       }

       // Display the contents of the array list
       System.out.println("\nCities in the array list:");
       for (String city : cities) {
           System.out.println(city);
       }

       // Remove all elements from the array list
       cities.clear();

       // Confirm the removal
       System.out.println("\nCities after removing all elements:");
       if (cities.isEmpty()) {
           System.out.println("The array list is empty.");
       } else {
           // This block won't execute as the list is empty
           System.out.println("Error: Failed to remove elements.");
       }
   }
}
