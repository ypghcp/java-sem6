import java.sql.*;

public class Scroll {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            // Establish connection to the database
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "", "");

            // Create a statement with scrollable ResultSet
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            // Execute a query to fetch data from the Teacher table
            resultSet = statement.executeQuery("SELECT * FROM Teacher");

            // Move the cursor to the last row of the ResultSet
            resultSet.last();

            // Get the total number of rows in the ResultSet
            int totalRows = resultSet.getRow();

            // Move the cursor to the first row of the ResultSet
            resultSet.beforeFirst();

            // Iterate over the ResultSet and display the data
            System.out.println("Teacher Table:");
            System.out.println("TNo\tTName\tSubject");
            while (resultSet.next()) {
                int tid = resultSet.getInt("TNo");
                String tname = resultSet.getString("TName");
                String salary = resultSet.getString("Subject");
                System.out.println(tid + "\t" + tname + "\t" + salary);
            }

            // Display the total number of rows in the ResultSet
            System.out.println("Total Rows: " + totalRows);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close the resources
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
