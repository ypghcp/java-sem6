import java.util.Scanner;
import java.sql.*;

public class employee {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "", "");
            System.out.println("Connection successful!");

            while (true) 
            {
                System.out.println("\nMenu:");
                System.out.println("1. Insert");
                System.out.println("2. Update");
                System.out.println("3. Display");
                System.out.println("4. Exit");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        insertEmployee(connection, scanner);
                        break;
                    case 2:
                        updateEmployee(connection, scanner);
                        break;
                    case 3:
                        displayEmployees(connection);
                        break;
                    case 4:
                        System.out.println("Exiting...");
                        return;
                    default:
                        System.out.println("Invalid choice!");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            scanner.close();
        }
    }

    private static void insertEmployee(Connection connection, Scanner scanner) throws SQLException {
        System.out.println("\nEnter employee details:");
        System.out.print("Enter employee number: ");
        int eno = scanner.nextInt();
        System.out.print("Enter employee name: ");
        String ename = scanner.next();
        System.out.print("Enter salary: ");
        double salary = scanner.nextDouble();

        String sql = "INSERT INTO Employees (ENo, EName, Salary) VALUES (?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, eno);
        statement.setString(2, ename);
        statement.setDouble(3, salary);
        int rowsInserted = statement.executeUpdate();
        if (rowsInserted > 0) {
            System.out.println("Employee inserted successfully.");
        } else {
            System.out.println("Failed to insert employee.");
        }
    }

    private static void updateEmployee(Connection connection, Scanner scanner) throws SQLException {
        System.out.print("\nEnter employee number to update: ");
        int eno = scanner.nextInt();
        System.out.print("Enter new salary: ");
        double salary = scanner.nextDouble();

        String sql = "UPDATE Employees SET Salary = ? WHERE ENo = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setDouble(1, salary);
        statement.setInt(2, eno);
        int rowsUpdated = statement.executeUpdate();
        if (rowsUpdated > 0) {
            System.out.println("Employee updated successfully.");
        } else {
            System.out.println("Employee not found or failed to update.");
        }
    }

    private static void displayEmployees(Connection connection) throws SQLException {
        String sql = "SELECT * FROM Employees";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        System.out.println("\nEmployee details:");
        while (resultSet.next()) {
            int eno = resultSet.getInt("ENo");
            String ename = resultSet.getString("EName");
            double salary = resultSet.getDouble("Salary");
            System.out.println("ENo: " + eno + ", EName: " + ename + ", Salary: " + salary);
        }
    }
}

