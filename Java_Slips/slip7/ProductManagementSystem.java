import java.sql.*;
import java.util.Scanner;

public class ProductManagementSystem {
        public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "", "");
            Statement statement = connection.createStatement();

            // Create Product table if not exists
          
            Scanner scanner = new Scanner(System.in);
            int choice;
            do {
                System.out.println("Menu:");
                System.out.println("1. Add a Product");
                System.out.println("2. Display all Products");
                System.out.println("3. Exit");
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        addProduct(connection, scanner);
                        break;
                    case 2:
                        displayAllProducts(statement);
                        break;
                    case 3:
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a valid option.");
                }
            } while (choice != 3);

            statement.close();
            connection.close();
            scanner.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void addProduct(Connection connection, Scanner scanner) throws SQLException {
        System.out.print("Enter product name: ");
        String pname = scanner.nextLine();
        System.out.print("Enter product price: ");
        double price = scanner.nextDouble();

        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Product (Pname, Price) VALUES (?, ?)");
        preparedStatement.setString(1, pname);
        preparedStatement.setDouble(2, price);
        int rowsAffected = preparedStatement.executeUpdate();
        if (rowsAffected > 0) {
            System.out.println("Product added successfully.");
        } else {
            System.out.println("Failed to add product.");
        }
    }

    private static void displayAllProducts(Statement statement) throws SQLException {
        ResultSet resultSet = statement.executeQuery("SELECT * FROM Product");
        System.out.println("Products:");
        System.out.println("ID\tName\t\tPrice");
        while (resultSet.next()) {
            int pid = resultSet.getInt("Pid");
            String pname = resultSet.getString("Pname");
            double price = resultSet.getDouble("Price");
            System.out.println(pid + "\t" + pname + "\t\t" + price);
        }
        resultSet.close();
    }
}
