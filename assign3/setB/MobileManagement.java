import java.sql.*;

public class MobileManagement {

    private static final String url = "jdbc:postgresql://localhost:5432/your_database";
    private static final String user = "username";
    private static final String password = "password";

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Usage: java MobileManagement <operation>");
            System.out.println("Operations:");
            System.out.println("1. Insert");
            System.out.println("2. Modify");
            System.out.println("3. Delete");
            System.out.println("4. Search");
            System.out.println("5. View All");
            System.out.println("6. Exit");
            return;
        }

        int operation = Integer.parseInt(args[0]);
        switch (operation) {
            case 1:
                if (args.length == 10) {
                    insertMobile(args);
                } else {
                    System.out.println("Usage: java MobileManagement 1 <Model_Number> <Model_Name> <Model_Color> <Sim_Type> <NetworkType> <BatteryCapacity> <InternalStorage> <RAM> <ProcessorType>");
                }
                break;
            case 2:
                if (args.length == 3) {
                    modifyMobile(args);
                } else {
                    System.out.println("Usage: java MobileManagement 2 <Model_Number> <New_Model_Color>");
                }
                break;
            case 3:
                if (args.length == 2) {
                    deleteMobile(args);
                } else {
                    System.out.println("Usage: java MobileManagement 3 <Model_Number>");
                }
                break;
            case 4:
                if (args.length == 2) {
                    searchMobile(args);
                } else {
                    System.out.println("Usage: java MobileManagement 4 <Model_Number>");
                }
                break;
            case 5:
                viewAllMobiles();
                break;
            case 6:
                System.out.println("Exiting program...");
                break;
            default:
                System.out.println("Invalid operation.");
        }
    }

    private static void insertMobile(String[] args) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO MOBILE VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
            for (int i = 1; i <= 9; i++) {
                statement.setString(i, args[i]);
            }
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Mobile inserted successfully.");
            } else {
                System.out.println("Failed to insert mobile.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void modifyMobile(String[] args) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            PreparedStatement statement = connection.prepareStatement("UPDATE MOBILE SET Model_Color = ? WHERE Model_Number = ?");
            statement.setString(1, args[2]);
            statement.setString(2, args[1]);
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Mobile updated successfully.");
            } else {
                System.out.println("Failed to update mobile. Mobile not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void deleteMobile(String[] args) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM MOBILE WHERE Model_Number = ?");
            statement.setString(1, args[1]);
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Mobile deleted successfully.");
            } else {
                System.out.println("Failed to delete mobile. Mobile not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void searchMobile(String[] args) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM MOBILE WHERE Model_Number = ?");
            statement.setString(1, args[1]);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                System.out.println("Mobile Details:");
                System.out.println("Model Number: " + resultSet.getString("Model_Number"));
                System.out.println("Model Name: " + resultSet.getString("Model_Name"));
                System.out.println("Model Color: " + resultSet.getString("Model_Color"));
                System.out.println("SIM Type: " + resultSet.getString("Sim_Type"));
                System.out.println("Network Type: " + resultSet.getString("NetworkType"));
                System.out.println("Battery Capacity: " + resultSet.getString("BatteryCapacity"));
                System.out.println("Internal Storage: " + resultSet.getString("InternalStorage"));
                System.out.println("RAM: " + resultSet.getString("RAM"));
                System.out.println("Processor Type: " + resultSet.getString("ProcessorType"));
            } else {
                System.out.println("Mobile not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void viewAllMobiles() {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM MOBILE");
            System.out.println("Mobile Details:");
            while (resultSet.next()) {
                System.out.println("Model Number: " + resultSet.getString("Model_Number"));
                System.out.println("Model Name: " + resultSet.getString("Model_Name"));
                System.out.println("Model Color: " + resultSet.getString("Model_Color"));
                System.out.println("SIM Type: " + resultSet.getString("Sim_Type"));
                System.out.println("Network Type: " + resultSet.getString("NetworkType"));
                System.out.println("Battery Capacity: " + resultSet.getString("BatteryCapacity"));
                System.out.println("Internal Storage: " + resultSet.getString("InternalStorage"));
                System.out.println("RAM: " + resultSet.getString("RAM"));
                System.out.println("Processor Type: " + resultSet.getString("ProcessorType"));
                System.out.println("----------------------------------------");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
