import java.sql.*;
import java.util.Scanner;

public class DeleteEmployee {

    public static void main(String[] args) {
        // Check if command line argument is provided
        if (args.length != 1) {
            System.out.println("Usage: java DeleteEmployee <employee_id>");
            return;
        }

        int employeeId = Integer.parseInt(args[0]);

        Connection connection = null;
        try {
            connection =  DriverManager.getConnection("jdbc:mysql://localhost:3306/", "", "");
            System.out.println("Connection successful!");

            // Delete employee details
            deleteEmployee(connection, employeeId);

            System.out.println("Employee details deleted successfully.");
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
        }
    }

    private static void deleteEmployee(Connection connection, int employeeId) throws SQLException {
        String sql = "DELETE FROM Employee WHERE ENo = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, employeeId);

        int rowsAffected = statement.executeUpdate();
        if (rowsAffected > 0) {
            System.out.println("Employee with ID " + employeeId + " deleted successfully.");
        } else {
            System.out.println("No employee found with ID " + employeeId + ".");
        }
    }
}

