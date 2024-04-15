import java.sql.*;

public class TeacherDetails {

    public static void main(String[] args) {
        try {
            // Establish connection
            Connection connection =  DriverManager.getConnection("jdbc:mysql://localhost:3306/","","");

            // Display details of teachers teaching "JAVA" subject
            displayJavaTeachers(connection);

            // Close connection
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

   
    private static void displayJavaTeachers(Connection connection) throws SQLException {
        // SQL query to select teachers teaching "JAVA" subject
        String selectQuery = "SELECT * FROM Teacher WHERE Subject = ?";

        // Prepare a statement
        PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);

        // Set parameter for subject
        preparedStatement.setString(1, "JAVA");

        // Execute query
        ResultSet resultSet = preparedStatement.executeQuery();

        // Display details of Java teachers
        System.out.println("Details of teachers teaching JAVA subject:");
        System.out.println("-------------------------------------------");
        while (resultSet.next()) {
            int tNo = resultSet.getInt("TNo");
            String tName = resultSet.getString("TName");
            String subject = resultSet.getString("Subject");
            System.out.println("TNo: " + tNo + ", TName: " + tName + ", Subject: " + subject);
        }
    }
}
